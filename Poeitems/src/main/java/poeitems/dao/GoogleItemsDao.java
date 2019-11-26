/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.dao;

import java.util.List;
import static poeitems.dao.GoogleSheetsConnector.readDataSheets;

/**
 *
 * @author patrhenr
 */
public class GoogleItemsDao {
    
    private static List<List<Object>> items;
    
    public GoogleItemsDao() throws Exception{
        items = readDataSheets();
    }
   
    public static List<List<Object>> importItems() {
        
        return items;
    }
    
}
