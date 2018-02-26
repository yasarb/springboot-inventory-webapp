package com.ysrbdlgn.spring.webapp.service;

import com.ysrbdlgn.spring.webapp.domain.User;
import com.ysrbdlgn.spring.webapp.domain.UserAddForm;
import com.ysrbdlgn.spring.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(UserAddForm userForm) {

        User user = new User(userForm.getUsername(), userForm.getPassword());
        user.setName(userForm.getName());
        user.setLastName(userForm.getLastName());

        userRepository.save(user);
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
