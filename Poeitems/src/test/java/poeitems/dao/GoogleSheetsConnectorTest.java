/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author patrhenr
 */
public class GoogleSheetsConnectorTest {
    
    private static List<List<Object>> itemsList;

    public GoogleSheetsConnectorTest() {

    }

    @Before
    public void setUp() throws Exception {

        itemsList = new ArrayList<>();
        itemsList = GoogleSheetsConnector.readDataSheets();

    }

    @Test
    public void GoogleSheetsConnectionWorks() throws Exception {

        boolean emptylist = itemsList.isEmpty();

        assertEquals(false, emptylist);
    }


    @Test
    public void writeToGoogleSheets() throws Exception {
        boolean write = false;

        GoogleSheetsConnector.writeToDataSheets("test", "test", "test", "test", "test");

        List<Objects> test = GoogleSheetsConnector.readDataSheets();

        if (itemsList.size() < test.size()) {
            write = true;
        }

        assertEquals(true, write);
    }

}
