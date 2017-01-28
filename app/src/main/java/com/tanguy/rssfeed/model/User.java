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

    public boolean loginValidation() {
        return (this.login != null && this.password != null);
    }

    public boolean signupValidation(String password) {
        return (this.login != null && this.password != null && this.password.equals(password));
    }
}