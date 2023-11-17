package com.hrrs.Service;

import com.hrrs.Model.User.Role;
import com.hrrs.Model.User.User;
import com.hrrs.Repository.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements Serializable {
    private static List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }


    public String registerUser(String username, String password, Role roles) throws Exception {
        User newUser = new User(username, password, roles);
        //read from file and add in users
        users = UserRepository.readCSV();
        if (users.size() == 0) {
            users.add((newUser));
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
                    return "You have a profile and just need to login to it";
                } else {
                    users.add(newUser);
                    break;
                }
            }

        }

        //write users in file
        UserRepository.writeToFile();
        return "Successful register";
    }

    public User login(String username, String password) throws Exception {
        users = UserRepository.readCSV();
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

