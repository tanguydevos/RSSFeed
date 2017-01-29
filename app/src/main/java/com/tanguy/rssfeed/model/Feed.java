package com.tanguy.rssfeed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feed {
    @JsonProperty("title")
    public String title;
    @JsonProperty("content")
    public String content;
    @JsonProperty("url")
    public String url;
    @JsonProperty("ttl")
    public String ttl;

    public Feed() {
        super();
    }
}