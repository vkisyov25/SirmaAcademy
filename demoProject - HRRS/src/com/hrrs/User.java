package com.hrrs;

import java.util.List;

public class User {
    private String username;
    private String password;
    private List<String> bookingHistory;

    public User(String username, String password, List<String> bookingHistory) {
        this.username = username;
        this.password = password;
        this.bookingHistory = bookingHistory;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(List<String> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }
}
