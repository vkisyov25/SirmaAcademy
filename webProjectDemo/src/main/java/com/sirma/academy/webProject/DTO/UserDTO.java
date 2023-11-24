package com.sirma.academy.webProject.DTO;

import com.sirma.academy.webProject.Model.Reservation;
import com.sirma.academy.webProject.Service.ReservationService;

import java.util.List;

public class UserDTO {

    private ReservationService reservationService;


    private long ID;
    private String name;

    private List<Reservation> reservationList;


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList() {
        this.reservationList = (List<Reservation>) reservationService.reservationByUser_id(getID());
    }
}
