package com.academy.sirma.restdbapp.DTO;

import com.academy.sirma.restdbapp.Model.User;

public class UserMapper {

    public static  UserDTO toUserDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
