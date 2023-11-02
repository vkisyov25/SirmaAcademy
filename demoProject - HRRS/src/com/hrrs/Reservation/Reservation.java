package com.hrrs.Reservation;

import com.hrrs.Room.Room;
import com.hrrs.Room.Status;
import com.hrrs.User.User;

public class Reservation {
    private User user;
    private Room room;
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

    public Room getRoom() {
        return room;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    //TODO: Can you have a mistake
    public void cancelReservation() {
        Status status = Status.AVAILABLE;
    }
}
