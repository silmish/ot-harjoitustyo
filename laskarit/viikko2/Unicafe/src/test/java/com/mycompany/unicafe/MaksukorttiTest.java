package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void OnkoSaldoOikein() {
        Maksukortti kortti = new Maksukortti(1000);

        int euroa = kortti.saldo()/100;
        int senttia = kortti.saldo()%100;
        
        String vastaus = "saldo: "+euroa+"."+senttia;

        assertEquals("saldo: 10.0", vastaus);
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        Maksukortti kortti = new Maksukortti(1000);

        String vastaus = kortti.toString();

        assertEquals("saldo: 10.0", vastaus);
    }

    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(500);

        String vastaus = kortti.toString();
        assertEquals("saldo: 15.0", vastaus);
    }

    @Test
    public void VahentaaSaldoaOikeinJosRahaaTarpeeksi() {
        Maksukortti kortti = new Maksukortti(1000);

        kortti.otaRahaa(500);
        String vastaus = kortti.toString();

        assertEquals("saldo: 5.0", vastaus);
    }

    @Test
    public void VahentaaSaldoaOikeinJosRahaaEiOleTarpeeksi() {
        Maksukortti kortti = new Maksukortti(1000);

        kortti.otaRahaa(5000);
        String vastaus = kortti.toString();

        assertEquals("saldo: 10.0", vastaus);
    }

    @Test
    public void PalauttaaTrueJosRahatRiittävät() {
        Maksukortti kortti = new Maksukortti(1000);
        Boolean vastaus = true;
        if (kortti.otaRahaa(500) == true) {
            vastaus = true;
        }

        assertEquals(true, vastaus);
    }

    @Test
    public void PalauttaaFalseJosRahatRiittävät() {
        Maksukortti kortti = new Maksukortti(1000);

        Boolean vastaus = true;

        if (kortti.otaRahaa(5000) == false) {
            vastaus = false;
        }

        assertEquals(false, vastaus);
    }

}
