package com.ysrbdlgn.spring.webapp.service;

import com.ysrbdlgn.spring.webapp.domain.Item;
import com.ysrbdlgn.spring.webapp.domain.User;
import com.ysrbdlgn.spring.webapp.domain.UserAddForm;
import com.ysrbdlgn.spring.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.*;

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

    @Override
    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<String>();

        for (User user : getUsers()) {
            usernames.add(user.getUsername());
        }

        return usernames;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Map<String, List<Item>> numberOfItemsByType(long userId) {
        Map<String, List<Item>> map = new HashMap<>();
        Set<Item> items = getUserById(userId).getItems();

        for (Item item : items) {
            List<Item> itemList = new ArrayList<>();
            String key = item.getType().toLowerCase();

            if (map.containsKey(key))
                itemList = map.get(key);

            itemList.add(item);
            map.put(key, itemList);
        }

        return map;
    }
}
