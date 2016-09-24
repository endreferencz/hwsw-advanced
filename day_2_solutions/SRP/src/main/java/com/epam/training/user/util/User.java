package com.epam.training.user.util;

public class User {

    private String email;

    private String password;

    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + "]";
    }

}
