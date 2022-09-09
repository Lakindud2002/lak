package com.lakindu.api.DAO;

import com.lakindu.api.model.Item;
import org.springframework.stereotype.Repository;
import com.lakindu.api.model.Items;

import java.util.Objects;


@Repository
public class ItemDAO
{
    private static Items list = new Items();

    static
    {
        list.getitemsList().add(
                new Item(
                        "A",
                        "Product 1",
                        "Description 1",
                        10.00)
        );
        list.getitemsList().add(
                new Item(
                        "B",
                        "Product 2",
                        "Description 2",
                        11.00)
        );
        list.getitemsList().add(
                new Item(
                        "C",
                        "Product 3",
                        "Description 3",
                        12.00)
        );
        list.getitemsList().add(
                new Item(
                        "D",
                        "Product 4",
                        "Description 4",
                        13.00)
        );
        list.getitemsList().add(
                new Item(
                        "E",
                        "Product 5",
                        "Description 5",
                        14.00)
        );
    }

    public static Items get_list()
    {
        return list;
    }


    public static void add_item(Item item)
    {
        list.getitemsList().add(item);
    }

    public Item update_item(String id, Item data)
    {
        Item item = null;
        boolean found = false;

        for (int i=0; i<list.getitemsList().size() && !found; ++i)
            if (Objects.equals(list.getitemsList().get(i).getId(), id))
            {
                item = list.getitemsList().get(i);
                found = true;
            }

        if (found) {
            if (data.getId() != null)
                item.setId(data.getId());

            if (data.getName() != null)
                item.setName(data.getName());

            if (data.getDesc() != null)
                item.setDesc(data.getDesc());

            if (data.getPrice() != 0.0)
                item.setPrice(data.getPrice());
        }

        return item;
    }

    public static void delete_item(String id)
    {
        Item item = null;
        boolean found = false;

        for (int i=0; i<list.getitemsList().size() && !found; ++i)
            if (Objects.equals(list.getitemsList().get(i).getId(), id))
            {
                found = true;
                list.getitemsList().remove(i);
            }
    }
}
