package com.sirma.academy.webProject.DTO;

import com.sirma.academy.webProject.Model.User;
import com.sirma.academy.webProject.Service.ReservationService;

public class UserMapper {

    public static UserDTO getUserDTOById(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setID(user.getID());
        userDTO.setName(user.getName());
        userDTO.setReservationList(ReservationService.getAllReservationByUser_id(user.getID()));
        return userDTO;
    }
}
