package com.hrrs;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<String> bookingHistory;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bookingHistory = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void addBooking(String bookingDetails) {
        bookingHistory.add(bookingDetails);
    }

    public List<String> getBookingHistory() {
        return bookingHistory;
    }

}
