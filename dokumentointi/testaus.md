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

![testikattavuus](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/Kuvat/testikattavuus.png)

Testien rivikattavuus on 54%, alhainen rivi- ja haaratuvuuskattavuus johtuu siitä että luokan GoogleSheetsDao rivejä ei onnistuttu kattamaan testeissä.

### Toiminnallisuus

Kaikki toiminnallisuudet jotka on määrittelydokumentissa ja käyttöohjeen toiminnallisuudet on testattu automaattisesti ja manuaalisesti. Jokainen erikoistapaus ei ole huomioitu testeissä taikka koodissa.

## Sovellukseen jääneet laatuongelmat

Sovellus ei ota huomioon jokaista erikoistapausta. Mikäli syötetään tyhjiä tietoa jne, ei niistä ole virheilmoituksia. Sovelluksen toiminnallisuus ongelma joka on huomattu on clear napin käyttö esineiden listauksessa, jolloin dropdown listoihin jää vielä jäljelle vanha valinta, eikä resetoi tätä. Tämä tuottaa hieman ongelmia käytettävyyden kannalta sillä joutuu vaihtamaan esineitä ja poistamaan ne jotta saman saa uudestaan valittua, mikäli siihen tarve.
