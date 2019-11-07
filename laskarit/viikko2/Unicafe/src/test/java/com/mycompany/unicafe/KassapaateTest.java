/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author patrhenr
 */
public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void OnkoRahanSaldoOikein() {
        Kassapaate kassa = new Kassapaate();

        String vastaus = String.valueOf(kassa.kassassaRahaa());

        assertEquals("100000", vastaus);
    }

    @Test
    public void OnkoLounaidenSaldoOikein() {
        Kassapaate kassa = new Kassapaate();

        int edullisia = kassa.edullisiaLounaitaMyyty();
        int maukkaita = kassa.maukkaitaLounaitaMyyty();

        String vastaus = String.valueOf(edullisia + maukkaita);

        assertEquals("0", vastaus);
    }

    @Test
    public void NouseekoKassanRahaEdullisellaOstolla() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoEdullisesti(240);

        String vastaus = String.valueOf(kassa.kassassaRahaa());

        assertEquals("100240", vastaus);
    }

    @Test
    public void NouseekoKassanRahaMaukkaallaOstolla() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoMaukkaasti(400);

        String vastaus = String.valueOf(kassa.kassassaRahaa());

        assertEquals("100400", vastaus);
    }

    @Test
    public void OnkoVaihtoRahaOikeinMaukkailla() {
        Kassapaate kassa = new Kassapaate();

        String vastaus = String.valueOf(kassa.syoMaukkaasti(450));

        assertEquals("50", vastaus);
    }

    @Test
    public void OnkoVaihtoRahaOikeinEdullisilla() {
        Kassapaate kassa = new Kassapaate();

        String vastaus = String.valueOf(kassa.syoEdullisesti(250));

        assertEquals("10", vastaus);
    }

    @Test
    public void NouseekoMyytyjenLounaidenMaaraEdullisilla() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoEdullisesti(240);

        String vastaus = String.valueOf(kassa.edullisiaLounaitaMyyty());

        assertEquals("1", vastaus);
    }

    @Test
    public void NouseekoMyytyjenLounaidenMaaraMaukkailla() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoMaukkaasti(400);

        String vastaus = String.valueOf(kassa.maukkaitaLounaitaMyyty());

        assertEquals("1", vastaus);
    }
    @Test
    public void VaihtuukoMyytyjenLounaidenMaaraJosRahaEiRiitaMaukkailla() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoMaukkaasti(390);

        String vastaus = String.valueOf(kassa.maukkaitaLounaitaMyyty());

        assertEquals("0", vastaus);
    }
    @Test
    public void VaihtuukoMyytyjenLounaidenMaaraJosRahaEiRiitaEdullisilla() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoEdullisesti(230);

        String vastaus = String.valueOf(kassa.edullisiaLounaitaMyyty());

        assertEquals("0", vastaus);
    }
    
    @Test
    public void PalautuukoMaksuKunRahatEiRiitaEdullisilla() {

        String vastaus = String.valueOf(kassa.syoEdullisesti(230));

        assertEquals("230", vastaus);
    }
    
    @Test
    public void PalautuukoMaksuKunRahatEiRiitaMaukkailla() {

        String vastaus = String.valueOf(kassa.syoMaukkaasti(390));

        assertEquals("390", vastaus);
    }
    
    @Test
    public void RahaMaaraEiNouseKunRahaEiRiitaEdullisilla() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoEdullisesti(230);

        String vastaus = String.valueOf(kassa.kassassaRahaa());

        assertEquals("100000", vastaus);
    }
    
    @Test
    public void RahaMaaraEiNouseKunRahaEiRiitaMaukkailla() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoMaukkaasti(390);

        String vastaus = String.valueOf(kassa.kassassaRahaa());

        assertEquals("100000", vastaus);
    }
    
    @Test
    public void KortillaOnTarpeeksiRahaaMaukkailla() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoMaukkaasti(kortti);

        String vastaus = String.valueOf(kortti.saldo());

        assertEquals("600", vastaus);
    }
    
    @Test
    public void KortillaOnTarpeeksiRahaaEdullisilla() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoEdullisesti(kortti);

        String vastaus = String.valueOf(kortti.saldo());

        assertEquals("760", vastaus);
    }
    
    @Test
    public void KortillaOnTarpeeksiRahaaMaukkaillaJaPalautetaanTrue() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoMaukkaasti(kortti);

        boolean vastaus = kassa.syoMaukkaasti(kortti);
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void KortillaOnTarpeeksiRahaaEdullisillaJaPalautetaanTrue() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoMaukkaasti(kortti);

        boolean vastaus = kassa.syoEdullisesti(kortti);
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void KortillaOnTarpeeksiRahaaEdullisillaJaLounaidenMaaraKasvaa() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoEdullisesti(kortti);

        String vastaus = String.valueOf(kassa.edullisiaLounaitaMyyty());

        assertEquals("1", vastaus);
    }
    
    @Test
    public void KortillaOnTarpeeksiRahaaMaukkaillaJaLounaidenMaaraKasvaa() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoMaukkaasti(kortti);

        String vastaus = String.valueOf(kassa.maukkaitaLounaitaMyyty());

        assertEquals("1", vastaus);
    }
    
    @Test
    public void KortillaEiOleTarpeeksiRahaaOstaaMaukastaJaKortinRahaMaaraEiMuutu() {
        Kassapaate kassa = new Kassapaate();
        
        Maksukortti kortti = new Maksukortti(350);

        kassa.syoMaukkaasti(kortti);

        String vastaus = String.valueOf(kortti.saldo());

        assertEquals("350", vastaus);
    }
    
    @Test
    public void KortillaEiOleTarpeeksiRahaaOstaaEdullistaJaKortinRahaMaaraEiMuutu() {
        Kassapaate kassa = new Kassapaate();
        
        Maksukortti kortti = new Maksukortti(220);

        kassa.syoEdullisesti(kortti);

        String vastaus = String.valueOf(kortti.saldo());

        assertEquals("220", vastaus);
    }
    
    @Test
    public void KortillaEiOleTarpeeksiRahaaOstaaMaukastaJaMyytyjenLounaidenMaaraEiMuutu() {
        Kassapaate kassa = new Kassapaate();
        
        Maksukortti kortti = new Maksukortti(350);

        kassa.syoMaukkaasti(kortti);

        String vastaus = String.valueOf(kassa.maukkaitaLounaitaMyyty());

        assertEquals("0", vastaus);
    }
    
    @Test
    public void KortillaEiOleTarpeeksiRahaaOstaaEdullistaJaMyytyjenLounaidenMaaraEiMuutu() {
        Kassapaate kassa = new Kassapaate();
        
        Maksukortti kortti = new Maksukortti(220);

        kassa.syoEdullisesti(kortti);

        String vastaus = String.valueOf(kassa.edullisiaLounaitaMyyty());

        assertEquals("0", vastaus);
    }
    
    @Test
    public void KortillaEiOleTarpeeksiRahaaOstaaMaukastaJaPalautuuFalse() {
        Kassapaate kassa = new Kassapaate();
        
        Maksukortti kortti = new Maksukortti(350);

        kassa.syoMaukkaasti(kortti);

        boolean vastaus = kassa.syoMaukkaasti(kortti);

        assertEquals(false, vastaus);
    }
    
    @Test
    public void KortillaEiOleTarpeeksiRahaaOstaaEdullistaJaPalautuuFalse() {
        Kassapaate kassa = new Kassapaate();
        
        Maksukortti kortti = new Maksukortti(220);

        kassa.syoEdullisesti(kortti);

        boolean vastaus = kassa.syoEdullisesti(kortti);

        assertEquals(false, vastaus);
    }
    
    @Test
    public void KassanRahaMaaraEiNouseKunOstaaKortillaMaukkaita() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoMaukkaasti(kortti);

        String vastaus = String.valueOf(kassa.kassassaRahaa());

        assertEquals("100000", vastaus);
    }
    
    @Test
    public void KassanRahaMaaraEiNouseKunOstaaKortillaEdullisesti() {
        Kassapaate kassa = new Kassapaate();

        kassa.syoEdullisesti(kortti);

        String vastaus = String.valueOf(kassa.kassassaRahaa());

        assertEquals("100000", vastaus);
    }
    
    @Test
    public void KassanRahaMaaraNouseeLadatunSaldonMukaan() {
        Kassapaate kassa = new Kassapaate();

        kassa.lataaRahaaKortille(kortti, 100);

        String vastaus = String.valueOf(kassa.kassassaRahaa());

        assertEquals("100100", vastaus);
    }
    
    @Test
    public void KortinSaldoNouseeKassallaLadatunSummanMukaan() {
        Kassapaate kassa = new Kassapaate();

        kassa.lataaRahaaKortille(kortti, 100);

        String vastaus = String.valueOf(kortti.saldo());

        assertEquals("1100", vastaus);
    }
    
    @Test
    public void KortinSaldoLadataanNegatiivisellaLuvulla() {
        Kassapaate kassa = new Kassapaate();

        kassa.lataaRahaaKortille(kortti, -100);

        String vastaus = String.valueOf(kortti.saldo());

        assertEquals("1000", vastaus);
    }
}
