/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author patrhenr
 */
public class GoogleSheetsDaoTest {
    
    private List<Items> itemObjects;
    FakeItems item;
    
    public GoogleSheetsDaoTest() {
       item = new FakeItems();
    }
   
    @Before
    public void setUp() {
        
        itemObjects = item.getItems();
    }
    
    @Test
    public void getRightItemsToDropDownLists() {
        
        String type = "helmet";
        
        List<String> sortedItems = new ArrayList<>();
        itemObjects.stream().filter((items) -> (items.getType().equals(type))).forEachOrdered((items) -> {
            sortedItems.add(items.getName());
        });
        
        assertEquals(sortedItems.get(0), "The Baron");
        
    }
    
    @Test
    public void getRightItemsLocations() {
        
        String name = "The Baron";
        List<Items> locations = new ArrayList<>();

        for (Items row : itemObjects) {
            if (row.getName().equals(name)) {
                locations.add(row);
            }
        }
        
        assertEquals(locations, itemObjects);
        
    }

    @Test
    public void getRightItemsMap() {
        
        String name = "And";
        List<Items> locations = new ArrayList<>();

        for (Items row : itemObjects) {
            if (row.getMap().equals(name)) {
                locations.add(row);
            }
        }
        
        assertEquals(locations, itemObjects);
        
    }
    
    @Test
    public void getRightItemsDivCard() {
        
        String name = "The one";
        List<Items> locations = new ArrayList<>();

        for (Items row : itemObjects) {
            if (row.getDivCard().equals(name)) {
                locations.add(row);
            }
        }
        
        assertEquals(locations, itemObjects);
        
    }
    
    @Test
    public void getRightItemsArea() {
        
        String name = "Only";
        List<Items> locations = new ArrayList<>();

        for (Items row : itemObjects) {
            if (row.getArea().equals(name)) {
                locations.add(row);
            }
        }
        
        assertEquals(locations, itemObjects);
        
    }
    
}
