package com.academy.sirma.restdbapp.Service;

import com.academy.sirma.restdbapp.Model.User;
import com.academy.sirma.restdbapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user){
        userRepository.register(user);
    }

    public List<User> getUserById(int id){
        return  userRepository.getUserById(id);
    }
}
