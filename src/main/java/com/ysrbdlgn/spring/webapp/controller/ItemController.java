package com.ysrbdlgn.spring.webapp.controller;

import com.ysrbdlgn.spring.webapp.domain.ItemAddForm;
import com.ysrbdlgn.spring.webapp.service.ItemService;
import com.ysrbdlgn.spring.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ItemController {
    private ItemService itemService;
    private UserService userService;

    @Autowired
    public ItemController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @RequestMapping("/items")
    public ModelAndView getItemsPage() {
        return new ModelAndView("items", "items", itemService.getItems());
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
    public String handleItemDelete(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/items";
    }

    @RequestMapping("/items/add")
    public ModelAndView itemAddPage() {
        return new ModelAndView("addItem", "itemForm", new ItemAddForm());
    }


    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public String handleItemAdd(@Valid @ModelAttribute("itemForm") ItemAddForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "addItem";

        itemService.addItem(form);
        return "redirect:/items";
    }
}
