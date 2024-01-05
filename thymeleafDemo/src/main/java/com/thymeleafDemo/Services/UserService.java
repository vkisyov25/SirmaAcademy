package com.thymeleafDemo.Services;

import com.thymeleafDemo.Models.User;
import com.thymeleafDemo.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User findById(long id){
        return userRepository.findById(id);
    }

}
