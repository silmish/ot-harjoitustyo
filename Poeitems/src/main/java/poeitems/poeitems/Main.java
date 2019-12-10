package poeitems.poeitems;

import java.util.Arrays;
import java.util.List;
import poeitems.ui.PoeitemsUI;
import poeitems.dao.GoogleItemsDao;
import domain.Items;
import domain.ItemsService;
import poeitems.dao.ItemsDao;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        GoogleItemsDao.importItems();

        PoeitemsUI.main(args);
    }

}
