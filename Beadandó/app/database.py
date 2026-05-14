import os
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
from dotenv import load_dotenv

# 1. Betöltjük a .env fájlt (lokális fejlesztéshez)
load_dotenv()

# --- DESIGN PATTERN: SINGLETON (EGYKEKE) ---
# Magyarázat: A Singleton minta biztosítja, hogy egy osztálynak csak egyetlen példánya 
# létezzen az egész alkalmazásban. Ez az adatbázis-kapcsolatoknál kritikus, 
# hogy ne nyissunk feleslegesen sok kapcsolatot az engine-nel.
class DatabaseManager:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(DatabaseManager, cls).__new__(cls)
            
            # 2. Lekérjük az adatbázis URL-t a környezeti változókból.
            SQLALCHEMY_DATABASE_URL = os.getenv("DATABASE_URL", "sqlite:///./crypto_trend.db")

            # 3. Különleges javítás Render.com-hoz:
            if SQLALCHEMY_DATABASE_URL.startswith("postgres://"):
                SQLALCHEMY_DATABASE_URL = SQLALCHEMY_DATABASE_URL.replace("postgres://", "postgresql://", 1)

            # 4. Beállítjuk a connect_args-ot
            connect_args = {}
            if "sqlite" in SQLALCHEMY_DATABASE_URL:
                connect_args = {"check_same_thread": False}

            # 5. Létrehozzuk az engine-t és a sessionmaker-t
            cls._instance.engine = create_engine(
                SQLALCHEMY_DATABASE_URL, connect_args=connect_args
            )
            cls._instance.SessionLocal = sessionmaker(
                autocommit=False, autoflush=False, bind=cls._instance.engine
            )
            
        return cls._instance

# Példányosítjuk a managert (ez lesz az egyetlen példány)
db_manager = DatabaseManager()

# Exportáljuk a szükséges változókat a kompatibilitás megőrzése érdekében
engine = db_manager.engine
SessionLocal = db_manager.SessionLocal

Base = declarative_base()