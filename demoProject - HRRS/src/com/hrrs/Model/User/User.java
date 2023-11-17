package com.hrrs.Model.User;

import com.hrrs.Model.Reservation.Reservation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String username;
    private String password;
    private static List<Reservation> bookingHistory;
    private Role roles;

    //TODO: Validation for password.
    public User(String username, String password, Role roles) {


        this.username = username;
        this.password = password;
        this.roles = roles;
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

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public static List<Reservation> getBookingHistory() {
        return bookingHistory;
    }

    public static void addBookingHistory(Reservation reservation) {
        bookingHistory.add(reservation);
    }

    @Override
    public String toString() {
        //return username+","+password+","+bookingHistory +","+roles;
        return username + "," + password + "," + roles;
    }
}
