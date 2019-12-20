# PoeItems

Sovelluksen avulla on mahdollista selvittää erinlaiset tavat saada tieynlaisia tavaroita pelissä Path of Exile. Sovelluksen avulla on mahdollista luoda oma hahmo jolle kerätä halutut tavarat ja näin nähdä
listaus tavoista miten tavart voi saada.

## Dokumentointi

[Kayttoohje.md](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

[vaatimusmaarittely.md](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[tuntikirjanpito.md](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

[arkkitehtuuri.md](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[testausdokumentti.md](https://github.com/silmish/ot-harjoitustyo/blob/master/dokumentointi/testaus.md)

## Releaset

[Viikko 5](https://github.com/silmish/ot-harjoitustyo/releases/tag/viikko5)

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

