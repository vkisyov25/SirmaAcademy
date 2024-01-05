package com.thymeleafDemo.Controllers;

import com.thymeleafDemo.Models.User;
import com.thymeleafDemo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/save")
    public String showUserForm(Model model){
        model.addAttribute("user",new User());
        return "myPage";
    }

    @PostMapping("/save")
    public String saveUser(User user){
        userService.saveUser(user);
        return "MyPage";
    }
}
