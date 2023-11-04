package com.hrrs;

import com.hrrs.User.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public String registerUser(String username, String password) {
        User newUser = new User(username, password);
        if(users.size()==0){
            users.add((newUser));
        }else {
            for (int i=0; i<users.size(); i++) {
                if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
                    return "You have a profile and just need to login to it";
                }else {
                    users.add(newUser);
                    break;
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

    public static List<User> getUsers() {
        return users;
    }
}

