package com.academy.sirma.restdbapp.Controller;

import com.academy.sirma.restdbapp.Model.User;
import com.academy.sirma.restdbapp.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        try {
            userService.register(user);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/userById/{id}")
    public List<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

}
