/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.domain;

/**
 *
 * Class for item generation.
 */
public class Items {

    private String name;
    private String type;
    private String map;
    private String divcard;
    private String area;

    public Items(String type, String name, String divcard, String map, String area) {

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

    public String getDivCard() {
        return divcard;
    }

    public String getArea() {
        return area;
    }

}
