/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author patrhenr
 */
public class GoogleItemsDao {

    private static List<List<Object>> items;

    public GoogleItemsDao() {

    }

    public static void importItems() throws Exception {
        items = GoogleSheetsConnector.readDataSheets();
    }
    
    public static List itemLocations(Object name) {
        
       List<List<Object>> locations = items.stream()
                .filter(item -> item.get(1).equals(name))
                .collect(Collectors.toList());
       
        System.out.println(locations.size());
       
        return locations;
    }

    /**
     *
     * @return @throws Exception
     */
    public static List readHelmets() throws Exception {

        List<List<Object>> helmet = items.stream()
                .filter(item -> item.get(0).equals("helmet"))
                .collect(Collectors.toList());

        List<Object> helmetnames = new ArrayList<>();

        for (List row : helmet) {
            helmetnames.add(row.get(1));
        }

        return helmetnames;
    }

    public static List readArmors() throws Exception {

        List<List<Object>> armor = items.stream()
                .filter(item -> item.get(0).equals("armor"))
                .collect(Collectors.toList());

        List<Object> armornames = new ArrayList<>();

        for (List row : armor) {
            armornames.add(row.get(1));
        }

        return armornames;
    }

    public static List readMainHands() throws Exception {

        List<List<Object>> mainhand = items.stream()
                .filter(item -> item.get(0).equals("main-hand"))
                .collect(Collectors.toList());

        List<Object> mainhandnames = new ArrayList<>();

        for (List row : mainhand) {
            mainhandnames.add(row.get(1));
        }

        return mainhandnames;
    }

    public static List readOffHands() throws Exception {

        List<List<Object>> offhand = items.stream()
                .filter(item -> item.get(0).equals("off-hand"))
                .collect(Collectors.toList());

        List<Object> offhandnames = new ArrayList<>();

        for (List row : offhand) {
            offhandnames.add(row.get(1));
        }

        return offhandnames;
    }

    public static List readAmulets() throws Exception {

        List<List<Object>> amulet = items.stream()
                .filter(item -> item.get(0).equals("amulet"))
                .collect(Collectors.toList());

        List<Object> amuletnames = new ArrayList<>();

        for (List row : amulet) {
            amuletnames.add(row.get(1));
        }

        return amuletnames;
    }

    public static List readRings() throws Exception {

        List<List<Object>> ring = items.stream()
                .filter(item -> item.get(0).equals("ring"))
                .collect(Collectors.toList());

        List<Object> ringnames = new ArrayList<>();

        for (List row : ring) {
            ringnames.add(row.get(1));
        }

        return ringnames;
    }

    public static List readBelts() throws Exception {

        List<List<Object>> belt = items.stream()
                .filter(item -> item.get(0).equals("belt"))
                .collect(Collectors.toList());

        List<Object> beltnames = new ArrayList<>();

        for (List row : belt) {
            beltnames.add(row.get(1));
        }

        return beltnames;
    }

    public static List readGloves() throws Exception {

        List<List<Object>> glove = items.stream()
                .filter(item -> item.get(0).equals("gloves"))
                .collect(Collectors.toList());

        List<Object> glovenames = new ArrayList<>();

        for (List row : glove) {
            glovenames.add(row.get(1));
        }

        return glovenames;
    }

    public static List readBoots() throws Exception {

        List<List<Object>> boots = items.stream()
                .filter(item -> item.get(0).equals("boots"))
                .collect(Collectors.toList());

        List<Object> bootsnames = new ArrayList<>();

        for (List row : boots) {
            bootsnames.add(row.get(1));
        }

        return bootsnames;
    }

}
