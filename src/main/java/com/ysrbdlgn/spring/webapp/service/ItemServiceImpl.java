package com.ysrbdlgn.spring.webapp.service;

import com.ysrbdlgn.spring.webapp.domain.Item;
import com.ysrbdlgn.spring.webapp.domain.ItemAddForm;
import com.ysrbdlgn.spring.webapp.domain.User;
import com.ysrbdlgn.spring.webapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final UserService userService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    @Override
    public void addItem(ItemAddForm form) {
        for (int i = 0; i < form.getAmount(); i++) {
            String inventoryCode = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(6);
            Item item = new Item(inventoryCode, form.getItemType());
            itemRepository.save(item);
        }
    }

    @Override
    public Iterable<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteItemById(long id) {
        itemRepository.delete(id);
    }

    @Override
    public Item getItemsById(long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public Item assignItem(String username, long itemId) {
        User user = userService.getUserByUsername(username);
        Item item = itemRepository.findOne(itemId);

        Set<Item> itemList = user.getItems();
        itemList.add(item);
        user.setItems(itemList);
        item.setUser(user);

        return itemRepository.save(item);
    }
}
