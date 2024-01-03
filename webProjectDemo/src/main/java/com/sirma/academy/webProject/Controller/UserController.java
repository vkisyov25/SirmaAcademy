package com.sirma.academy.webProject.Controller;

import com.sirma.academy.webProject.DTO.UserDTO;
import com.sirma.academy.webProject.DTO.UserMapper;
import com.sirma.academy.webProject.Model.User;
import com.sirma.academy.webProject.Service.UserService;
import com.sirma.academy.webProject.Validation.UserValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

   /* @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }*/

    @PostMapping("/registration")
    public ResponseEntity<String> register(@RequestBody User user) {
        boolean isHave = false;
        //VALIDATION
        if (UserValidation.userValidation(user)) {
            isHave = userService.addUser(user);
        } else {
            return new ResponseEntity<>("Invalid data format", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (isHave) {
            return new ResponseEntity<>("Successfully registration", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Already exist", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/userByID/{id}")
    public UserDTO userById(@PathVariable long id) {
        return UserMapper.getUserDTOById(userService.getUserById(id));
    }
}
