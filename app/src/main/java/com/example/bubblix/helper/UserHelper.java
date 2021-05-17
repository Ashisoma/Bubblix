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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
