package com.lakindu.api.controller;

import com.lakindu.api.DAO.ItemDAO;
import com.lakindu.api.model.Item;
import com.lakindu.api.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemDAO itemDao;

    @GetMapping(path="/", produces = "application/json")
    public Items getEmployees()
    {
        return itemDao.get_list();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public Item getEmployees(@PathVariable String id)
    {
        Item returnItem = new Item();
        boolean found = false;

        for (int i=0; i<itemDao.get_list().getitemsList().size() && !found; ++i)
            if (Objects.equals(itemDao.get_list().getitemsList().get(i).getId(), id))
            {
                returnItem = itemDao.get_list().getitemsList().get(i);
                found = true;
            }

        return returnItem;
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public Item addItem(@RequestBody Item newItem)
    {
        itemDao.add_item(newItem);
        return itemDao.get_list().getitemsList().get(Integer.parseInt(newItem.getId()));
    }

    @PutMapping(path="/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item item)
    {
        return itemDao.update_item(id, item);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteItem(@PathVariable String id)
    {
        itemDao.delete_item(id);
    }
}
