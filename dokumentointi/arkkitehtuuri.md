# Arkkitehtuurikuvaus 

## Rakenne

Sovellusksen pakkausrakenne on seuraava:

![pakkausrakenne]()

Pakkaus poeitems.ui sisältää javaFX:llä toteutetun käyttöliittymän ohjelmalle.
Pakkaus poeitems.dao sisältää tietojen hakemiseen liittyvän koodin google sheetsistä.

## Käyttöliittymä

Kättöliittymä sisältää kaksi eri näkymää:
- Item location
- Add item

Käyttöliittymässä on yksi päänäkymä ja toinen näkymä koskien esineiden lisäämiselle mikäli puuttuvat tietokannasta.

Jokainen näkymä on toteutettu omana tabina ja näkyvät yksi kerrallaan. Käyttöliittymä on rakennettu luokkaan poeitems.ui.PoeitemsUi.

Käyttöliittymästä on pyritty eriyttämään sovelluslogiikka mutta sinne on jokunen jouduttu rakentamaan aikataulujen takia. Käyttöliittymää ei ole kerety täysin refaktoromoimaan jotta siitä saisi täysin sovelluslogiikan pois.


## Sovelluslogiikka

Sovelluslogiikan datamallin muodostaa luokka Items, joka kuvaa esineiden tietoja.

Sovelluksen sydän on GoogleSheetsDao luokka joka hyodyntää Items luokan esine tietoja ja hakee GoogleSheetsConnection luokasta esine listan tietokannasta.

Pakkausten ja luokkien suhdetta kuvaava kuva: 
![Pakkauskaavio]()

##  Tietojenhaku ja tallennus

Pakkaus poeitems.dao sisältää luokat GoogleSheetsConnector ja  GoogleItemsDao jotka huolehtivat tietojen kirjoittamista ja hakemista google sheetsistä ja niiden edelleen viemisestä käyttöliittymään. Luokat eivät vielä toteuta kunnolla DAO suunnittelumallia.

## Päätoiminnallisuudet

Kuvassa näkyy tietojen hakeminen google sheetsistä ja miten ne saadaan näkymään oikeassa kohdassa käyttöliittymässä.

![Sekvenssikaavio](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/Kuvat/Add%20items%20to%20display%20locations.png)

## Ohjelman rakenteeseen jääneet heikkoudet

Ohjelmassa on suurin heikkous on DAO sunnittelumallin puuttuminen. Tämä oli työ alla mutta valitettavasti se ei ikinä lähteny toimimaan GoogleSheetsin kanssa joten jouduin aikataulujen takia unohtamaan tämän. DAO malli antaisi ohjelmalle paljon selkeämmän tietojensiirron ja paremman luokka rakenteen. 

Käyttöliittymään on jouduttu upottamaan harmittavan paljon sovelluslogiikkaa ja tämän tekee siitä hyvin sekavan luokan. Tämä pitäisi täysin refaktoroida jotta siitä saisi selkeämmän ja helpomman laajentaa jatkossa. Yksi suuri asia olisi hyödyntää FXML:lää, joka antaisi työkalut selkeämpään käyttöliittymä suunnitteluun.
