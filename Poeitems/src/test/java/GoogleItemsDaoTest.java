/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import poeitems.dao.GoogleSheetsConnector;

/**
 *
 * @author patrhenr
 */
public class GoogleItemsDaoTest {
    
    public static List<List<Object>> items;
    
    public GoogleItemsDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        
        items = new ArrayList<>();
        items = GoogleSheetsConnector.readDataSheets();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void GoogleSheetsConnectionWorks() throws Exception{   
    
        
        boolean emptylist = items.isEmpty();
        
        assertEquals(false, emptylist);
    }
    
    /*@Test
    public void GettingRightItemsLocation() throws Exception{
        
        items = GoogleSheetsConnector.readDataSheets();
        
        String helmet = "The Baron";
        
        List<List<Object>> locations = items.stream()
                .filter(item -> item.get(0).equals(helmet))
                .collect(Collectors.toList());
        
        assertEquals(helmet, locations.get(1)); 
    }*/
    
    @Test
    public void AreTheTypesRightPerQueryHelmets() {
        List<List<Object>> helmet = items.stream()
                .filter(item -> item.get(0).equals("helmet"))
                .collect(Collectors.toList());
        
        List<Object> helmetnames = new ArrayList<>();

        for (List row : helmet) {
            helmetnames.add(row.get(0));
        }
        
        assertEquals("helmet", helmetnames.get(0));
    }
    
    @Test
    public void  AreTheTypesRightPerQueryArmors() {      
    
    List<List<Object>> armor = items.stream()
                .filter(item -> item.get(0).equals("armor"))
                .collect(Collectors.toList());

        List<Object> armornames = new ArrayList<>();

        for (List row : armor) {
            armornames.add(row.get(0));
        }
        
        assertEquals("armor", armornames.get(0));
    }
    
    @Test
    public void  AreTheTypesRightPerQueryMainHands() {      
    
    List<List<Object>> mainhand = items.stream()
                .filter(item -> item.get(0).equals("main-hand"))
                .collect(Collectors.toList());

        List<Object> mainhandnames = new ArrayList<>();

        for (List row : mainhand) {
            mainhandnames.add(row.get(0));
        }
        
        assertEquals("main-hand", mainhandnames.get(0));
    }
    
    @Test
    public void  AreTheTypesRightPerQueryOffHands() {      
    
    List<List<Object>> mainhand = items.stream()
                .filter(item -> item.get(0).equals("off-hand"))
                .collect(Collectors.toList());

        List<Object> offhandnames = new ArrayList<>();

        for (List row : mainhand) {
            offhandnames.add(row.get(0));
        }
        
        assertEquals("off-hand", offhandnames.get(0));
    }
    
    @Test
    public void  AreTheTypesRightPerQueryAmulets() {      
    
    List<List<Object>> mainhand = items.stream()
                .filter(item -> item.get(0).equals("amulet"))
                .collect(Collectors.toList());

        List<Object> amuletnames = new ArrayList<>();

        for (List row : mainhand) {
            amuletnames.add(row.get(0));
        }
        
        assertEquals("amulet", amuletnames.get(0));
    }
    
    @Test
    public void  AreTheTypesRightPerQueryRings() {      
    
    List<List<Object>> mainhand = items.stream()
                .filter(item -> item.get(0).equals("ring"))
                .collect(Collectors.toList());

        List<Object> ringnames = new ArrayList<>();

        for (List row : mainhand) {
            ringnames.add(row.get(0));
        }
        
        assertEquals("ring", ringnames.get(0));
    }
    
    @Test
    public void  AreTheTypesRightPerQueryBelts() {      
    
    List<List<Object>> mainhand = items.stream()
                .filter(item -> item.get(0).equals("belt"))
                .collect(Collectors.toList());

        List<Object> beltnames = new ArrayList<>();

        for (List row : mainhand) {
            beltnames.add(row.get(0));
        }
        
        assertEquals("belt", beltnames.get(0));
    }
    
    @Test
    public void  AreTheTypesRightPerQueryGloves() {      
    
    List<List<Object>> mainhand = items.stream()
                .filter(item -> item.get(0).equals("gloves"))
                .collect(Collectors.toList());

        List<Object> glovesnames = new ArrayList<>();

        for (List row : mainhand) {
            glovesnames.add(row.get(0));
        }
        
        assertEquals("gloves", glovesnames.get(0));
    }
    
    @Test
    public void  AreTheTypesRightPerQueryBoots() {      

    List<List<Object>> mainhand = items.stream()
                .filter(item -> item.get(0).equals("boots"))
                .collect(Collectors.toList());

        List<Object> bootsnames = new ArrayList<>();

        for (List row : mainhand) {
            bootsnames.add(row.get(0));
        }
        
        assertEquals("boots", bootsnames.get(0));
    }
}
