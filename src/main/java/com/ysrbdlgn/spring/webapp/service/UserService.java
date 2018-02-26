package com.ysrbdlgn.spring.webapp.service;

import com.ysrbdlgn.spring.webapp.domain.Item;
import com.ysrbdlgn.spring.webapp.domain.User;
import com.ysrbdlgn.spring.webapp.domain.UserAddForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface UserService extends UserDetailsService {

    void addUser(UserAddForm userForm);

    Iterable<User> getUsers();

    List<String> getUsernames();

    User getUserByUsername(String username);

    User getUserById(long id);

    Map<String, List<Item>> numberOfItemsByType(long userId);

}
