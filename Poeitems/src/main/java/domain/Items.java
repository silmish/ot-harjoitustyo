/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author patrhenr
 */
public class Items {
    
    private String name;
    private String type;
    private String map;
    private String divcard;
    private String area;
    
    
    public Items(String name, String type, String map, String divcard, String area) {
        this.name = name;
        this.type = type;
        this.map = map;
        this.divcard = divcard;
        this.area = area;
       
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getDivcard() {
        return divcard;
    }

    public void setDivcard(String divcard) {
        this.divcard = divcard;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    
}
