package com.tanguy.rssfeed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Channel {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("link")
    public List<Link> link;
    @JsonProperty("description")
    public String description;
    @JsonProperty("language")
    public String language;
    @JsonProperty("image")
    public Thumbnail thumbnail;
    @JsonProperty("article_number")
    public Integer article_number;

    public Channel() {
        super();
    }
}

