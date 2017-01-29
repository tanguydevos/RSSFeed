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
    public boolean signupValidation(String passwordConfirmation) {
        return this.login != null && this.password != null && passwordConfirmation != null;
    }

    // Validates if user's attributes are OK for a signup attempt
    public boolean comparePasswords(String password, String passwordConfirmation) {
        return this.password.equals(passwordConfirmation);
    }
}