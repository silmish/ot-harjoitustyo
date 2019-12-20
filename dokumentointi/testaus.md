# Testausdokumentti

Ohjelmaa on testattu automatisoiduin JUnit testeillä ja manuaalisesti järjestelmätasolla.

## Automaattinentestaus

### Sovelluslogiikka

Automaattiset testit testaavat sovelluslogiikkaa joka on on lähinnä pakkauksessa GoogleSheetsDao. Items pakkauksen item-olioiden luonti on tämän ohessa testattu myös. Testaus luokan GoogleSheetsDao ei jostain syystä onnistunut, mutta toiminnallisuudet on testattu käyttäen FakeItems luokkaa.

### Tietokantayhteys

Tietokantana on käytetty Google sheetsiä. Yhteys on testattu molempiin suuntiin, luku ja kirjoitus. Yhteys on testatty osana sovelluslogiikkaa ja myös suora testaus on toteutettu.

### DAO-luokat

Dao luokkien testaus osoittautut hankalaksi. GoogleSheetsDao luokan testaus ei onnistunut ollenkaan, sillä testit eivät kohdistuneet kyseiseen luokkaan vaikka tämän toiminnallisuuksia testattiin. Tämän on kieretty hyödyntäen sovelluslogiikan testejä.


### Testauskattavuus

Käyttöliittymä pakkaus on jätetty kokonaan pois. Pakkauksien poeitems.dao ja poeitems.domain luokkien testaus on suoritettu kuten aikaisemmin kuvailtu. 

![testikattavuus]()
