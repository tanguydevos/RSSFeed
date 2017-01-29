package com.tanguy.rssfeed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Channel {
    @JsonProperty("title")
    public String title;
    @JsonProperty("link")
    public String link;
    @JsonProperty("description")
    public String description;
    @JsonProperty("language")
    public String language;
    @JsonProperty("image")
    public Thumbnail image;
    @JsonProperty("article_number")
    public Integer article_number;

    public Channel() {
        super();
    }
}

