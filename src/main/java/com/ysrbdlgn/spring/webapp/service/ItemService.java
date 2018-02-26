package com.ysrbdlgn.spring.webapp.service;

import com.ysrbdlgn.spring.webapp.domain.Item;
import com.ysrbdlgn.spring.webapp.domain.ItemAddForm;

public interface ItemService {

    void addItem(ItemAddForm form);

    Iterable<Item> getItems();

    void deleteItemById(long id);

}
