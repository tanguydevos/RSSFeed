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
}