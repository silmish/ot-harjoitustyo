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
    private int level;
    
    public Items(String name, String type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
       
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }
    
}
