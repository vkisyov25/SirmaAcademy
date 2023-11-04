package com.hrrs.Reservation;

import com.hrrs.Room.Room;
import com.hrrs.Room.Status;
import com.hrrs.User.User;

import java.util.Date;

public class Reservation {
    private User user;
    private Room room;
    //TODO: checkInDate and checkOutDate can make Data type, because there is a problem with the price calculation in ReservationManager
    private String checkInDate;
    private String checkOutDate;


    public Reservation(User user, Room room, String checkInDate, String checkOutDate) {
        this.user = user;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "user=" + user +
                ", room=" + room +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                '}';
    }
}



