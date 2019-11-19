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
public class Character {
    
    private String name;
    private String baseclass;
    
    
    public Character(String name, String baseclass) {
        this.name = name;
        this.baseclass = baseclass;
    }

    public String getName() {
        return name;
    }

    public String getBaseclass() {
        return baseclass;
    }
    
    
}
