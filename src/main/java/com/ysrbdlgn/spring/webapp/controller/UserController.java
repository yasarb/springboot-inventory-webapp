package com.ysrbdlgn.spring.webapp.controller;

import com.ysrbdlgn.spring.webapp.domain.User;
import com.ysrbdlgn.spring.webapp.domain.UserAddForm;
import com.ysrbdlgn.spring.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/register")
    public ModelAndView getRegisterPage() {
        return new ModelAndView("register", "userForm", new UserAddForm());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleRegisterForm(@Valid @ModelAttribute("userForm") UserAddForm userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "register";

        userService.addUser(userForm);
        return "redirect:/";
    }

    @RequestMapping("/users")
    public ModelAndView getUsersPAge() {
        return new ModelAndView("users", "users", userService.getUsers());
    }

}