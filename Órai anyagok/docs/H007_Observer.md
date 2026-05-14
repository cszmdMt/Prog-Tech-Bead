# Observer Tervezési Minta

## 1. Observer Pattern

### Alapinformáció

Az **Observer (Megfigyelő) mintázat** egy viselkedési tervezési minta, amely lehetővé teszi, hogy egy objektum (Subject) automatikusan értesítse a rá feliratkozott objektumokat (Observers), amikor az állapota megváltozik.

Ez egy **one-to-many kapcsolatot** valósít meg:
- Egy Subject
- Több Observer

---

### Mikor használd?

Az Observer mintát akkor érdemes használni, ha:

- Egy objektum változásait több másik objektumnak is követnie kell.
- Nem akarod szorosan összekapcsolni a komponenseket.
- Event-alapú rendszert szeretnél kialakítani.
- GUI eseménykezelést vagy real-time frissítéseket kezelsz.

Tipikus példák:
- GUI event handling (gomb kattintás)
- Hírlevél feliratkozás
- Árfolyamfigyelő rendszerek
- MVC architektúra (Model → View frissítés)

---

### Hogyan működik?

1. Van egy **Subject (tárgy)**, amely tárolja az állapotot.
2. Az **Observers (megfigyelők)** feliratkoznak a Subject-re.
3. Ha a Subject állapota megváltozik, értesíti az összes Observert.
4. Az Observers reagálnak a változásra.

![Ábra](./assets/observer_pattern.png)

---

## 2. Implementáció

### Alap interfészek

```java
interface Observer {
    void update(String message);
}

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

## 3. Előnyök és Hátrányok

### Előnyök

- Laza csatolás a komponensek között
- Dinamikus feliratkozás és leiratkozás
- Könnyen bővíthető rendszer
- Támogatja az event-driven architektúrát

### Hátrányok

- Sok Observer esetén teljesítményproblémák
- Nehéz lehet debugolni az eseményláncokat
- Memória szivárgás, ha nem jól kezeljük a leiratkozást

## 4. Összefoglalás

- Az Observer minta eseményalapú kommunikációt valósít meg.
- A Subject értesíti az Observer-eket állapotváltozás esetén.
- Segít a komponensek közötti függetlenség fenntartásában.
- Alapvető minta GUI, event system és reactive rendszerekhez.
