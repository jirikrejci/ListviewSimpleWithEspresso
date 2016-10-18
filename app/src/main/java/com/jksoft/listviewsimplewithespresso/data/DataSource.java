package com.jksoft.listviewsimplewithespresso.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jirka on 18.10.2016.
 */

public class DataSource {
    //@VisibleForTesting
    public static String HASH_MAP_ITEM_TEXT = "ROW_TEXT";
    //@VisibleForTesting
    public static String HASH_MAP_ITEM_ENABLED = "ENABLED_TEXT";
    private static final int NUMBER_OF_ITEMS = 100;
    private static final String ITEM_TEXT_FORMAT = "item: %d";

    // holder pro data
    private List <Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

    // konstruktor data source
    public DataSource () {
        populateData();
    }

    //@VisibleForTesting
    // vytvoreni jedne polozky jako Map - Each row is a collection of key-value pairs
    protected static Map<String, Object> createItem (int row) {
        Map<String, Object> dataItem = new HashMap<>();
        dataItem.put(HASH_MAP_ITEM_TEXT, String.format(ITEM_TEXT_FORMAT, row));
        dataItem.put(HASH_MAP_ITEM_ENABLED, row == 1); // enabled bude jen prvni polozka
        return  dataItem;
    }

    // vytvoreni kolekce polozek typu Map
    private void populateData () {
        for (int row = 0; row < NUMBER_OF_ITEMS; row ++) {
            mData.add(createItem(row));
        }
    }

    // getter pro data
    public List<Map<String,Object>> getData() {
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        data.addAll(mData);
        return data;
    }

}
