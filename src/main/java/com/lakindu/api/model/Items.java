package com.lakindu.api.model;

import java.util.ArrayList;
import java.util.List;


public class Items
{
    private List<Item> itemsList;

    public List<Item> getitemsList()
    {
        if (itemsList == null)
            itemsList = new ArrayList<>();

        return itemsList;
    }

    public void setitemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }
}
