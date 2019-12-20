/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import poeitems.domain.Items;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Class generates the data and items to be shown in the UI.
 *
 */
public class GoogleItemsDao {

    private static List<List<Items>> itemsList;
    private static List<Items> itemObjects;

    public GoogleItemsDao() {

    }

    /**
     * Generates a list of all the items found in GoogleSheets
     *
     * @throws java.lang.Exception
     */
    public static void importItems() throws Exception {
        itemObjects = new ArrayList<>();
        try {
            itemsList = GoogleSheetsConnector.readDataSheets();
        } catch (Exception ex) {
            Logger.getLogger(GoogleItemsDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<String> item = itemsList.stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());

        for (String rows : item) {
            String[] test = rows.split("[,?.@]+");
            Items newItem = new Items(test[0].replaceAll("[^a-zA-Z0-9]", ""), test[1], test[2], test[3], test[4].replaceAll("[^a-zA-Z0-9]", ""));
            itemObjects.add(newItem);
        }
    }

    /**
    *
    *Generates dropdown list data. Sorts by item type.
    *
     * @param item
     * @return 
     */
    public static List<String> getItems(String item) {

        List<String> sortedItems = new ArrayList<>();
        itemObjects.stream().filter((items) -> (items.getType().equals(item))).forEachOrdered((items) -> {
            sortedItems.add(items.getName());
        });
        return sortedItems;
    }

    /**
    *
    *Sends the selected item to the UI for location information generation.
    *
     * @param name
     * @return 
     */
    public static List itemLocations(String name) {

        List<Items> locations = new ArrayList<>();

        for (Items row : itemObjects) {
            if (row.getName().equals(name)) {
                locations.add(row);
            }
        }

        return locations;
    }

    /**
    *
    *Adds an new item to the GoogleSheets.
    *
     * @param type
     * @param name
     * @param divCard
     * @param map
     * @param area
     * @throws java.lang.Exception
     */
    public static void addItemstoSheets(String type, String name, String divCard, String map, String area) throws Exception {

        GoogleSheetsConnector.writeToDataSheets(type, name, divCard, map, area);
    }

}
