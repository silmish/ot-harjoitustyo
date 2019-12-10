/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import poeitems.dao.ItemsDao;

/**
 *
 * @author patrhenr
 */
public class ItemsService {

    private ItemsDao itemsDao;
    private List<List<Object>> items;

    public ItemsService(ItemsDao itemsdao) {
        this.itemsDao = itemsdao;

    }

    

}
