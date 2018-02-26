package com.ysrbdlgn.spring.webapp.service;

import com.ysrbdlgn.spring.webapp.domain.User;
import com.ysrbdlgn.spring.webapp.domain.UserAddForm;

public interface UserService {

    void addUser(UserAddForm userForm);

    Iterable<User> getUsers();
}
