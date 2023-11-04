package com.hrrs.User;

import com.hrrs.Reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private static List<Reservation> bookingHistory;

    //TODO: Validation for password (I can remove bookingHistory)
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        bookingHistory = new ArrayList<>();

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }


    public static List<Reservation> getBookingHistory() {
        return bookingHistory;
    }

    public void addBookingHistory(Reservation reservation) {
        this.bookingHistory.add(reservation);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bookingHistory=" + bookingHistory +
                '}';
    }
}
