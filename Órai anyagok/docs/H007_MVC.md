# MVC (Model–View–Controller) tervezési minta

Teljes esszé: [esszé](https://docs.google.com/document/d/1f4l9dMRwRPVaipQ4DnaLI3jlV1vFlPXNCfAjRzNzBxY/edit?usp=sharing)

## 1. Alapinformáció

Az **MVC (Model–View–Controller)** egy architekturális minta, amelyet szoftverek felépítésére használnak annak érdekében, hogy a kód:

- jól strukturált legyen
- könnyen karbantartható legyen
- skálázható maradjon
- elkülönítse az üzleti logikát a felhasználói felülettől

Az MVC három fő komponensből áll:

- **Model** → adat és üzleti logika
- **View** → megjelenítés (UI)
- **Controller** → vezérlés, input kezelése

---

## 2. Miért fontos az MVC?

Az MVC célja a **separation of concerns (felelősségek szétválasztása)**.

### Probléma MVC nélkül:
- UI és üzleti logika összekeveredik
- nehéz tesztelni
- nehéz bővíteni
- változtatás egyik részen tönkreteheti a másikat

### MVC előnyei:
- könnyebb karbantartás
- párhuzamos fejlesztés (frontend/backend külön)
- új UI könnyen cserélhető
- jobb tesztelhetőség
- tiszta architektúra

---

## 3. MVC komponensek

### 3.1 Model

A **Model** felelős:
- adatok tárolásáért
- üzleti logikáért
- szabályokért
- adatbázis műveletekért

Nem tud semmit a View-ról vagy Controller-ről.

Példa:
- User objektum
- Order logika
- adatbázis lekérdezések

---

### 3.2 View

A **View** felelős:
- adatok megjelenítéséért
- UI renderelésért
- felhasználói felületért

Nem tartalmaz üzleti logikát.

Példa:
- HTML oldal
- mobil UI (Android XML, SwiftUI)
- React komponens (view rétegként)

---

### 3.3 Controller

A **Controller**:
- fogadja a felhasználói inputot
- feldolgozza a kérést
- meghívja a Model-t
- kiválasztja a megfelelő View-t

Ez a „közvetítő” réteg.

---

## 4. MVC működése (folyamat)

1. Felhasználó interakciót végez (pl. gomb kattintás)
2. Controller fogadja az eseményt
3. Controller lekéri / módosítja a Model-t
4. Model frissül
5. Controller frissített adatot küld a View-nak
6. View megjeleníti az új állapotot

---

## 5. MVC diagram logika

- User → View
- View → Controller
- Controller → Model
- Model → Controller / View (frissítés)

---

## 6. MVC fajtái

### 6.1 Klasszikus MVC (Smalltalk eredet)

- Model aktívan értesíti a View-t
- erős kapcsolat lehet Model és View között
- desktop alkalmazásokban volt gyakori

---

### 6.2 Web MVC

Legelterjedtebb forma (pl. Spring MVC, ASP.NET MVC)

- HTTP request → Controller
- Controller → Model
- Model → View template (HTML generálás)

Jellemző:
- stateless HTTP alapú működés
- szerver oldali renderelés

---

### 6.3 Frontend MVC (SPA)

Modern webalkalmazásokban:

- Model = state (pl. Redux store)
- View = UI komponensek (React, Angular)
- Controller = event handling / actions

Példák:
- React + Redux
- Angular framework

---

### 6.4 MVP (Model–View–Presenter) – MVC variáns

- View passzív
- Presenter kezeli a logikát
- erősebb szétválasztás, mint MVC

---

### 6.5 MVVM (Model–View–ViewModel)

- ViewModel köti össze a View-t és Model-t
- data binding használata
- gyakori:
  - WPF (.NET)
  - Android (modern architecture)
  - Vue.js (részben MVVM jelleg)

---

## 7. MVC előnyei és hátrányai

### Előnyök

- tiszta architektúra
- jól skálázható
- könnyű tesztelni (unit testing)
- párhuzamos fejlesztés
- új UI könnyen cserélhető

---

### Hátrányok

- kisebb projektekhez túl komplex lehet
- sok boilerplate kód
- Controller túlzsúfolódhat („fat controller” probléma)
- nem mindig egyértelmű felelősséghatárok

---

## 8. Hol használják az MVC-t?

### Backend / Web frameworkök:
- Spring MVC (Java)
- ASP.NET MVC
- Django (MVC-hez hasonló MTV)
- Ruby on Rails

### Frontend:
- Angular (MVC/MVVM keverék)
- React (View layer, de MVC elvek szerint használható)
- Vue.js (MVVM)

### Desktop:
- Java Swing (MVC elv)
- .NET WPF (MVVM inkább)

---

## 9. Példa

```
class UserModel {
    private List<Observer> observers = new ArrayList<>();
    private String name;

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(name);
        }
    }
}
```

```
class UserView implements Observer {
    public void update(String name) {
        System.out.println("UI frissítve: " + name);
    }
}
```

```
class UserController {
    private UserModel model;

    public UserController(UserModel model) {
        this.model = model;
    }

    public void changeName(String name) {
        model.setName(name);
    }
}
```

---

## 10. MVC vs más architektúrák

| Architektúra | Fő cél |
|--------------|--------|
| MVC | UI + logika szétválasztása |
| MVP | View teljes leválasztása |
| MVVM | data binding alapú UI |
| Clean Architecture | rétegek és dependency control |

---

## 11. Összefoglalás

- MVC egy alapvető architekturális minta UI rendszerekhez
- 3 fő része: Model, View, Controller
- célja a felelősségek szétválasztása
- web, mobil és desktop rendszerekben is használják
- több modern variánsa létezik (MVVM, MVP)
- segíti a skálázhatóságot és karbantarthatóságot
