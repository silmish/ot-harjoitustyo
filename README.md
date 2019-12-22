# PoeItems

Sovelluksen avulla on mahdollista selvittää erinlaiset tavat saada tieynlaisia esineitä pelissä Path of Exile. Sovelluksen avulla on mahdollista rakentaa oma "hahmo" jolle kerätä halutut esineet ja näin nähdä
listaus tavoista miten ja mistä esineet voi saada.

## Dokumentointi

[Kayttoohje.md](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

[vaatimusmaarittely.md](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[tuntikirjanpito.md](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

[arkkitehtuuri.md](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[testausdokumentti.md](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/testaus.md)

## Releaset

[Viikko 7](https://github.com/silmish/ot-harjoitustyo/releases/tag/1.0)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon target suoritettavan jar-tiedoston Poeitems-1.0-SNAPSHOT.jar

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle


```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

