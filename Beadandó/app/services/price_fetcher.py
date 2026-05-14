import httpx
import logging
import abc
from sqlalchemy.orm import Session
from app import crud

# Beállítjuk a loggert
logger = logging.getLogger(__name__)

# --- DESIGN PATTERN: STRATEGY (STRATÉGIA) ---
# Magyarázat: A Strategy minta lehetővé teszi, hogy különböző algoritmusokat (adatforrásokat) 
# cserélhető módon használjunk. Ha holnap egy másik API-ra (pl. Binance) akarunk váltani, 
# csak egy új osztályt kell írnunk, a fő logikát nem kell bántani.

class PriceFetchStrategy(abc.ABC):
    @abc.abstractmethod
    async def fetch_prices(self, coin_names: list[str]) -> dict:
        pass

class CoinGeckoStrategy(PriceFetchStrategy):
    """Eredeti CoinGecko alapú lekérdezési stratégia."""
    API_URL = "https://api.coingecko.com/api/v3/simple/price"

    async def fetch_prices(self, coin_names: list[str]) -> dict:
        ids_string = ",".join(coin_names)
        async with httpx.AsyncClient() as client:
            try:
                response = await client.get(
                    self.API_URL,
                    params={"ids": ids_string, "vs_currencies": "usd"}
                )
                response.raise_for_status()
                return response.json()
            except Exception as e:
                logger.error(f"Hiba a CoinGecko letöltésekor: {e}")
                return {}

# --- DESIGN PATTERN: OBSERVER (MEGFIGYELŐ) ---
# Magyarázat: Az Observer minta segítségével "feliratkozhatunk" eseményekre. 
# Itt akkor értesítjük a megfigyelőket, ha egy coin ára sikeresen frissült.

class PriceObserver(abc.ABC):
    @abc.abstractmethod
    def on_price_updated(self, symbol: str, new_price: float):
        pass

class LoggingPriceObserver(PriceObserver):
    """Egy konkrét megfigyelő, ami naplózza a változásokat."""
    def on_price_updated(self, symbol: str, new_price: float):
        logger.info(f"OBSERVER: {symbol} ára frissült: ${new_price}")

class PriceSubject:
    def __init__(self):
        self._observers = []

    def attach(self, observer: PriceObserver):
        self._observers.append(observer)

    def notify(self, symbol: str, new_price: float):
        for observer in self._observers:
            observer.on_price_updated(symbol, new_price)

# Példányosítjuk a Subject-et és hozzáadunk egy alapértelmezett megfigyelőt
price_subject = PriceSubject()
price_subject.attach(LoggingPriceObserver())


async def update_prices(db: Session, strategy: PriceFetchStrategy = CoinGeckoStrategy()):
    """
    Ez a függvény végigmegy az adatbázisban lévő coinokon,
    a megadott stratégiával lekérdezi az aktuális árukat, és frissíti őket.
    """
    # 1. Lekérjük az összes coint az adatbázisból
    coins = crud.get_coins(db)

    if not coins:
        logger.warning("Nincs coin az adatbázisban, amit frissíteni lehetne.")
        return {"message": "Nincs coin az adatbázisban, amit frissíteni lehetne."}

    # 2. Összegyűjtjük a szimbólumokat
    coin_ids = [coin.name.lower() for coin in coins]

    # 3. Lekérjük az árakat a stratégiával
    data = await strategy.fetch_prices(coin_ids)
    
    if not data:
        return {"error": "Nem sikerült árakat lekérni a választott forrásból."}

    # 4. Frissítjük az adatbázist és értesítjük a megfigyelőket
    updated_count = 0
    for coin in coins:
        coin_key = coin.name.lower()

        if coin_key in data:
            new_price = data[coin_key]["usd"]
            crud.update_coin_price(db, coin.symbol, new_price)
            
            # ÉRTESÍTÉS: Itt hívjuk meg az Observer mintát
            price_subject.notify(coin.symbol, new_price)
            
            updated_count += 1

    logger.info(f"Sikeresen frissítve {updated_count} db coin ára!")
    return {"message": f"Sikeresen frissítve {updated_count} db coin ára!"}