package com.sirma.academy.webProject.Service;

import com.sirma.academy.webProject.Model.User;
import com.sirma.academy.webProject.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private  UserRepository userRepository;

    /*//public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    public boolean addUser(User user) {
        Optional<User> existingUser = userRepository.getUserByName(user.getName());
        Optional<User> existingUser1 = userRepository.getUsersByEmail(user.getEmail());
        if (!existingUser.isPresent()) {
            if (!existingUser1.isPresent()) {
                userRepository.save(user);
                return true;
            }

        }

        return false;
    }

    public User getUserById(long id) {
        return userRepository.getById(id);
    }

}
