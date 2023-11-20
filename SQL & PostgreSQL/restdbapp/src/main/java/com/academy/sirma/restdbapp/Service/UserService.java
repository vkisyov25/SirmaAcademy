package com.academy.sirma.restdbapp.Service;

import com.academy.sirma.restdbapp.Model.User;
import com.academy.sirma.restdbapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    public void register(User user){
        userRepository.register(user);
    }

}
