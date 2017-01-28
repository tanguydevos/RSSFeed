package com.tanguy.rssfeed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("login")
    public String login;
    @JsonProperty("password")
    public String password;
    @JsonProperty("token")
    public String token;

    public User() {
        super();
    }

    // Validates if user's attributes are OK for a login attempt
    public boolean loginValidation() {
        return (this.login != null && this.password != null);
    }

    // Validates if user's attributes are OK for a signup attempt
    public boolean signupValidation(String password) {
        return (this.login != null && this.password != null && this.password.equals(password));
    }
}