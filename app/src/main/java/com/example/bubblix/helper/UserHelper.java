package com.example.bubblix.helper;

public class UserHelper {
    public String fullName, email, location,password;

    public UserHelper() {
    }

    public UserHelper(String fullName, String email, String location, String password) {
        this.fullName = fullName;
        this.email = email;
        this.location = location;
        this.password = password;
    }
}
