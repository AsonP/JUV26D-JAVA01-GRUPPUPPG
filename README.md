# Fångdjupet

Ett textbaserat rollspel i konsolen där en hjälte slåss sig igenom en serie fiender i en fängelsehåla.
Gruppuppgift i kursen JAVA01 (JUV26D).

## Köra spelet

Kräver JDK 27 och Maven.

```
mvn compile exec:java -Dexec.mainClass=fangdjupet.Main
```

Eller öppna projektet i IntelliJ och kör `fangdjupet.Main`.

Köra testerna:

```
mvn test
```

## Projektstruktur och ansvar

| Paket | Innehåll | Ansvarig |
|---|---|---|
| `fangdjupet.contract` | Gemensamma interfaces, records och enums | Hela gruppen |
| `fangdjupet.combat` | Hjälte, fiender, anfallstyper och strid | |
| `fangdjupet.item` | Föremål, inventarium och fabriker | |
| `fangdjupet.game` | Meny, spelmotor, händelselogg och sparfunktion | |

## Designmönster

- **Strategy**: (motivering)
- **Factory**: (motivering)
- **Observer**: (motivering)

## Gruppreflektion kring Git-samarbetet

(Vad fungerade bra, vad var svårt, och hur löstes konflikter.)
