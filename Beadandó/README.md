# 💎 CryptoTrend Pro - Full Stack Kriptovaluta Elemző

**Eszterházy Károly Katolikus Egyetem — Programozási technológiák kurzus**

Ez a projekt egy többrétegű, modern webalkalmazás, amely valós idejű kriptovaluta piaci adatokat kezel, elemez és vizualizál. A rendszer demonstrálja a **FastAPI** (Backend) és a **Streamlit** (Frontend) integrációját, miközben kiemelt figyelmet fordít a szoftverarchitektúra minőségére és a tervezési minták alkalmazására.

## 🛠️ Alkalmazott Tervezési Minták (Design Patterns)

A projekt az ötös osztályzat elérése érdekében három alapvető tervezési mintát alkalmaz:

1.  **Singleton (Egykeke):** Az adatbázis-kapcsolatokat a `DatabaseManager` osztály kezeli (`app/database.py`), biztosítva, hogy az alkalmazásban csak egyetlen adatbázis-motor és sessionmaker példány létezzen, optimalizálva az erőforrás-felhasználást.
2.  **Strategy (Stratégia):** Az árfolyamok lekérdezése cserélhető stratégiákra épül (`app/services/price_fetcher.py`). Alapértelmezésben a CoinGecko API-t használja, de a moduláris felépítésnek köszönhetően bármikor könnyen hozzáadható más forrás a kód módosítása nélkül.
3.  **Observer (Megfigyelő):** A rendszer eseményvezérelt. Amikor egy kriptovaluta ára frissül, a `PriceSubject` automatikusan értesíti a regisztrált megfigyelőket (pl. naplózó modul), így a rendszer könnyen bővíthető új funkciókkal (pl. riasztásokkal).

## 🏗️ Architektúra és Technológiák

A rendszer moduláris felépítésű, szigorúan elválasztva a felelősségi köröket:

* **Backend (API Réteg):** `FastAPI` alapú REST API, `Uvicorn` szerverrel.
* **Adatbázis:** `SQLAlchemy` ORM (SQLite lokálisan).
* **Frontend (UI Réteg):** `Streamlit` alapú interaktív dashboard `Plotly` diagramokkal.

---

## 🚀 Telepítés és Indítás (Lokálisan)

A projekt futtatásához **Python 3.10+** szükséges.

### 1. Függőségek telepítése
Hozd létre a virtuális környezetet és telepítsd a függőségeket:

```bash
# Csomagok telepítése
pip install -r requirements.txt
```

### 2. Indítás
A teljes rendszer (Backend + Frontend) indításához futtasd a fő szkriptet:

```bash
python run.py
```

## 📂 Projektstruktúra

*   `app/`: A backend (FastAPI) forráskódja.
    *   `database.py`: Adatbázis konfiguráció (Singleton minta).
    *   `services/`: Üzleti logika (Strategy és Observer minták).
*   `frontend/`: A felhasználói felület (Streamlit).
*   `magyarazat.txt`: Részletes magyar nyelvű leírás a tervezési mintákról.

---
*Készült a Programozási technológiák kurzus beadandó feladataként.*
