package com.sirma.academy.webProject.Controller;

import com.sirma.academy.webProject.DTO.UserDTO;
import com.sirma.academy.webProject.DTO.UserMapper;
import com.sirma.academy.webProject.Model.User;
import com.sirma.academy.webProject.Service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.ConstructorProperties;


@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public void register(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/userByID/{id}")
    public UserDTO userById(@PathVariable long id){
        return UserMapper.getUserDTOById(userService.getUserById(id));
    }
}
