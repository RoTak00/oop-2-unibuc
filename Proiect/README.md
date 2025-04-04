# Programare Orientată pe Obiecte

## PokeMock - joc management creaturi fantastice

### Tema proiectului

În ideea jocurilor Pokemon, proiectul intenționează să permită utilizatorului să crească și să evolueze creaturi fantastice de diferite tipuri, prin hrănirea lor, oferirea de îngrijire sau folosirea lor pentru luptă.

#### Obiecte

- Being (Interfață cu diferite câmpuri - viață maximă, vitalitate, putere, apărare)
- Creature (Clasă abstractă care definește o creatură care poate fi îngrijită de jucător, implementează un Being)
- Monster (Clasă care definește un inamic cu care se poate lupta o Creatură, implementează un Being)
- Dragon (Tip de creatură, extinde un Creature. Are, în general, și putere mare, și apărare mare)
- Golem (Tip de creatură, extinde un Creature. Are, în general, apărare foarte mare, dar putere mai redusă)
- Phoenix (Tip de creatură, extinde un Creature. Are, în general, putere mare, dar apărare mai redusă)
- InventoryItem (Clasă abstractă care definește un obiect care poate fi ținut în inventar)
- FoodItem (Obiect care poate fi dat ca hrană unei creaturi - îi crește vitalitatea, și poate să îi crească puterea sau apărarea unei creaturi, extinde un InventoryItem)
- EvolutionAmulet (Obiect care poate fi oferit unei creaturi pentru a o evolua - îi crește toate elementele de status și rangul, extinde un InventoryItem)
- RevivalAmulet (Obiect care poate fi oferit unei creaturi pentru a o învia în cazul în care este moartă, extinde un InventoryItem)
- Amuletă de contopire (Obiect care poate fi folosit pe două creaturi pentru a le contopi și transforma într-o creatură mai puternică, extinde un InventoryItem) - nu e implementat
- Inventory (Obiect cu număr limitat de slot-uri unde pot fi ținute obiecte de tipul InventoryItem)
- Narator (Clasă cu funcții statice folosite pentru a afișa text / narațiune la diferite acțiuni) - nu e implementat
- BattleService (Clasă helper care efectuează toate operațiunile legate de lupta dintre un Creature și un Monster) 
- Game (Singleton folosit pentru acțiunile care pot fi luate în cadrul jocului, prin GameState)
- GameState (Interfață care expune două metode, display și handleInput. Template-ul pentru fiecare meniu din joc)
- MainMenuState (Implementează GameState, oferă acces la meniul de Creaturi și Inventar)
- CreatureSelectMenuState (Implementează GameState, permite selectarea unei creaturi)
- SingleCreatureActionState (Implementează GameState, permite acționarea asupra unei creaturi)
- UseItemOnCreatureState (Implementează GameState, permite utilizarea unui InventoryItem pe o creatură anterior selectată)
- FightState (Implementează GameState, prezintă lupta dintre o Creatură și un Monstru)
- FightFinishedState (Implementează GameState, prezintă rezultatul luptei dintre o Creatură și un Monstru)
- InventoryMenuState (Implementează GameState, permite selectarea unui InventoryItem)
- InventoryItemActionState (Implementează GameState, permite acționarea asupra unui InventoryItem)
- InventoryUseTargetState (Implementează GameState, permite selectarea creaturii pentru care să se aplice InventoryItem-ul anterior selectat)
- BeingFactory (Clasă helper care permite crearea claselor de tip Being)
- FoodFactory (Clasă helper care permite crearea claselor de tip FoodItem)
- NameFactory (Clasă helper care permite generarea numelor pentru Being sau pentru InventoryItem)
- ItemTemplate (Record cu 2 câmpuri pentru InventoryItem)
- InputHelper (Clasă helper care expune funcții pentru input)
- UIHelper (Clasă helper care expune funcții pentru afișarea meniurilor)-
- CreatureType (Enum care descrie tipurile de Creature)
- StatType (Enum care descrie tipurile de statistici ale unui Being)


#### Acțiuni

- Vezi listă creaturi - afișează numele și tipul creaturilor deținute de jucător
- Vezi detalii creatură - afișează informații despre o anumită creatură dețiunută de jucător
- Vezi inventar - afișează toate obiectele din inventarul jucătorului
- Folosește obiect inventar
	- Folosește mâncare - hrănește o creatură
	- Folosește amuletă de evoluție - crește rangul unei creaturi
	- Folosește amuletă de înviere - învie o creatură moartă
	- Folosește amuletă de contopire - contopește două creaturi într-una mai puternică - nu e implementat
- Mângâie creatură - crește puțin vitalitatea unei creaturi
- Trimite creatură la luptă - Plasează Creatura într-o luptă cu un Monster. Pierde viață și poate muri, dar dacă câștigă, primește un bonus de stats și poate descoperi InventoryItems utile pentru jucător.
- Alungă o creatură - Elimină o creatură din lista de creaturi deținute de jucător
- Îngroapă o creatură - Elimină (îngroapă) o creatură moartă din lista de creaturi deținute de jucător - nu e implementat
- Aruncă obiect - Elimină un obiect din lista de obiecte dețiune de jucător

### De implementat

Pe lângă ce e marcat ca „nu e implementat”, există numeroase feature-uri de implementat

#### Creaturi

- Redenumirea creaturilor
- Creștere automată în rank prin XP sau altfel
- Mai multe tipuri de creaturi (cu abilități speciale)
- Evoluție specifică pentru diferitele tipuri de creaturi
- Statistică Noroc, care poate duce la mai multe obiecte descoperite după o luptă

#### Obiecte

- Obiect pentru extinderea spațiului în inventar

#### Mecanisme

- Luptă de antrenament între două Creature
- Trimiterea unei creaturi la muncă pasivă pentru a deveni mai puternică de una singură
- Luptă în grup

Foarte multe altele pot fi gândite.

