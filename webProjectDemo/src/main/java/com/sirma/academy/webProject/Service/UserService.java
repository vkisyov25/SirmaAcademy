package com.sirma.academy.webProject.Service;

import com.sirma.academy.webProject.Model.User;
import com.sirma.academy.webProject.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public User getUserById(long id){
        return userRepository.getById(id);
    }
}
