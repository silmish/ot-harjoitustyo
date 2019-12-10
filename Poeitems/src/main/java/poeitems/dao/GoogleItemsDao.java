/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import domain.Items;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class generates the base for items to be shown in the UI 
 * 
 */
public class GoogleItemsDao {

    private static List<List<Items>> items;

    public GoogleItemsDao() {

    }
    /**
     * Generates a list of all the items found in GoogleSheets
     * 
     * @throws java.lang.Exception    
    */
    public static void importItems() throws Exception {
        items = GoogleSheetsConnector.readDataSheets();

        /*List<String> items = sheetsItems.stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());*/

 /*for (List<Items> rows : items) {
            String[] test = rows.split("[,?.@]+");
            Items item = new Items(test[0].replaceAll("[^a-zA-Z0-9]", ""), test[1], test[2], test[3], test[4].replaceAll("[^a-zA-Z0-9]", ""));
            //System.out.println(item.getType());
        }*/
    }

    /*public static List itemLocations(Object name) {

        List<List<Object>> locations = items.stream()
                .filter(item -> item.get(1).equals(name))
                .collect(Collectors.toList());

        return locations;
    }*/
    /**
     * Creating a list of all item types that have type helmet
     *
     * @return All the items that have type helmet
     * @throws java.lang.Exception
     */
    public static List readHelmets() throws Exception {

        List<Object> helmetNames = new ArrayList<>();

        for (List row : items) {

            if (row.get(0).equals("helmet")) {
                helmetNames.add(row.get(1));
            }

        }

        return helmetNames;
    }

    /**
     * Creating a list of all item types that have type armor
     *
     * @return All the items that have type armor
     * @throws java.lang.Exception
     */
    public static List readArmors() throws Exception {

        List<Object> armorNames = new ArrayList<>();

        for (List row : items) {
            if (row.get(0).equals("armor")) {
                armorNames.add(row.get(1));
            }
        }

        return armorNames;
    }

    /**
     * Creating a list of all item types that have type main-hand
     *
     * @return All the items that have type main-hand
     * @throws java.lang.Exception
     */
    public static List readMainHands() throws Exception {

        List<Object> mainHandNames = new ArrayList<>();

        for (List row : items) {
            if (row.get(0).equals("main-hand")) {
                mainHandNames.add(row.get(1));
            }
        }

        return mainHandNames;
    }

    /**
     * Creating a list of all item types that have type off-hand
     *
     * @return All the items that have type off-hand
     * @throws java.lang.Exception
     */
    public static List readOffHands() throws Exception {

        List<Object> offHandNames = new ArrayList<>();

        for (List row : items) {
            if (row.get(0).equals("off-hand")) {
                offHandNames.add(row.get(1));
            }
        }

        return offHandNames;
    }

    /**
     * Creating a list of all item types that have type amulet
     *
     * @return All the items that have type amulet
     * @throws java.lang.Exception
     */
    public static List readAmulets() throws Exception {

        List<Object> amuletNames = new ArrayList<>();

        for (List row : items) {
            if (row.get(0).equals("amulet")) {
                amuletNames.add(row.get(1));
            }
        }

        return amuletNames;
    }

    /**
     * Creating a list of all item types that have type ring
     *
     * @return All the items that have type ring
     * @throws java.lang.Exception
     */
    public static List readRings() throws Exception {

        List<Object> ringNames = new ArrayList<>();

        for (List row : items) {
            if (row.get(0).equals("ring")) {
                ringNames.add(row.get(1));
            }
        }

        return ringNames;
    }

    /**
     * Creating a list of all item types that have type belt
     *
     * @return All the items that have type belt
     * @throws java.lang.Exception
     */
    public static List readBelts() throws Exception {

        List<Object> beltNames = new ArrayList<>();

        for (List row : items) {
            if (row.get(0).equals("belt")) {
                beltNames.add(row.get(1));
            }
        }

        return beltNames;
    }

    /**
     * Creating a list of all item types that have type gloves
     *
     * @return All the items that have type gloves
     * @throws java.lang.Exception
     */
    public static List readGloves() throws Exception {

        List<Object> gloveNames = new ArrayList<>();

        for (List row : items) {
            if (row.get(0).equals("gloves")) {
                gloveNames.add(row.get(1));
            }
        }

        return gloveNames;
    }

    /**
     * Creating a list of all item types that have type boots
     *
     * @return All the items that have type boots
     * @throws java.lang.Exception
     */
    public static List readBoots() throws Exception {

        List<Object> bootsNames = new ArrayList<>();

        for (List row : items) {
            if (row.get(0).equals("boots")) {
                bootsNames.add(row.get(1));
            }
        }

        return bootsNames;
    }

}
