# Arkkitehtuurikivaus 

## Rakenne

Pakkaus poeitems.ui sisältää javaFX:llä toteutetun käyttöliittymän ohjelmalle.
Pakkaus poeitems.dao sisältää tietojen hakemiseen liittyvän koodin google sheetsistä.

## Käyttöliittymä

Käyttöliittymässä on yksi päänäkymä ja toinen näkymä koskien esineiden lisäämiselle mikäli puuttuvat tietokannasta.

Jokainen näkymä on toteutettu omana Scene-oliona ja näkyvät yksi kerrallaan. Jokainen scene on omana tabview:ssä. Käyttöliittymä on rakennettu luokkaan poeitems.ui.PoeitemsUi.

## Sovelluslogiikka
![Pakkausrakenne](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/pakkausrakenne.png)

##  Tietojenhaku

Pakkaus poeitems.dao sisältää luokat GoogleSheetsConnector ja  GoogleItemsDao jotka huolehtivat tietojen hakemisesta google sheetsistä ja niiden edelleen viemisestä käyttöliittymään. Luokat eivät vielä toetuta kunnolla DAO suunnittelumallia.

## Päätoiminnallisuudet

Kuvassa näkyy tietojen hakeminen google sheetsistä ja miten ne saadaan näkymään oikeassa kohdassa käyttöliittymässä.

![Sekvenssikaavio](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/Add%20items%20to%20display%20locations.png)

## Ohjelman rakenteeseen jääneet heikkoudet

Ohjelmassa on suurin heikkous on DAO sunnittelumallin puuttuminen. Tähän toivottavasti saadaan vielä korjaus ennen viimeistä versioita.
