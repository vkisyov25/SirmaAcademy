package com.hrrs;

import com.hrrs.User.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void registerUser(String username, String password) {
        User newUser = new User(username, password);
        users.add(newUser);
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }
}

