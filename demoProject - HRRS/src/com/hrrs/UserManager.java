package com.hrrs;

import com.hrrs.User.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public String registerUser(String username, String password) {
        User newUser = new User(username, password);
        if(users.size()==0){
            users.add((newUser));
        }else {
            //check - If there is s user with this name and this password don't save it.
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return "You have a profile and just need to login to it";
                }else {
                    users.add(newUser);
                }
            }

        }
        return "Successful register";
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

