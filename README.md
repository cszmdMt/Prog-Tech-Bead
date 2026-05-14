# Programozási technológiák - Kurzus Portfólió

Ez a repozitórium az Eszterházy Károly Katolikus Egyetem **Programozási technológiák** kurzusához kapcsolódó anyagokat tartalmazza, beleértve az órai gyakorlatokat és a féléves beadandó feladatot.

---

## 📂 Repozitórium felépítése

A projekt két fő részre oszlik:

### 1. [Beadandó](./Beadandó/) - CryptoTrend Pro
Ez a mappa tartalmazza a féléves beadandó projektet, amely egy **Full Stack Kriptovaluta Elemző** alkalmazás.

**A beadandó lényege:**
A projekt egy modern webalkalmazás, amely valós idejű kriptovaluta piaci adatokat kezel, elemez és vizualizál. A rendszer célja a tiszta kód elvek és a szoftverarchitektúra minőségének bemutatása, különös tekintettel a tervezési mintákra.

*   **Backend:** FastAPI alapú REST API, SQLAlchemy ORM-mel.
*   **Frontend:** Streamlit alapú interaktív dashboard Plotly diagramokkal.
*   **Tervezési Minták:**
    *   **Singleton (Egykeke):** Az adatbázis-kapcsolatok kezelésére (`app/database.py`).
    *   **Strategy (Stratégia):** Az árfolyam-lekérdezési algoritmusok cserélhetőségére (`app/services/price_fetcher.py`).
    *   **Observer (Megfigyelő):** Az árváltozások eseményvezérelt követésére (`app/services/price_fetcher.py`).

### 2. [Órai anyagok](./Órai%20anyagok/) - Gyakorlati feladatok
Ebben a mappában találhatók a félév során elvégzett gyakorlati feladatok és segédanyagok.

*   **H001 - H006:** A heti gyakorlatok forráskódjai (Java/Gradle projektek).
*   **docs:** Részletes dokumentációk a különböző tervezési mintákról (Strategy, State, Template Method, Factory, Singleton, Prototype, Builder, Adapter, Bridge, Observer, MVC).
*   **TeachingActivity.pdf:** A kurzushoz kapcsolódó oktatási tevékenység összefoglalója.
*   **jegyek.md:** Jegyzetek és fontos információk a kurzussal kapcsolatban.

---

## 🚀 Futtatás (Beadandó)

A beadandó projekt indításához navigálj a `Beadandó` mappába, telepítsd a függőségeket, majd futtasd a `run.py` szkriptet:

```bash
cd Beadandó
pip install -r requirements.txt
python run.py
```

---
*Készítette: cszmdMt (Máté)*
