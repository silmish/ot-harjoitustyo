/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author patrhenr
 */
public class FakeItems {

    List<Items> items = new ArrayList<>();

    public FakeItems() {
        items.add(new Items("helmet", "The Baron", "The one", "And", "Only"));
    }

    public String getItemType() {

        String type = "";

        for (Items item : items) {
            item.getType();
        }
        
        return type;
    }
    
    public String getItemName() {

        String name = "";

        for (Items item : items) {
            item.getName();
        }
        
        return name;
    }

    public List<Items> getItems() {
        return items;
    }
    
    public String getItemdivCard() {

        String divCard = "";

        for (Items item : items) {
            item.getDivCard();
        }
        
        return divCard;
    }
    
    public String getItemMap() {

        String map = "";

        for (Items item : items) {
            item.getMap();
        }
        
        return map;
    }
    
    public String getItemArea() {

        String area = "";

        for (Items item : items) {
            item.getArea();
        }
        
        return area;
    }
    

}
