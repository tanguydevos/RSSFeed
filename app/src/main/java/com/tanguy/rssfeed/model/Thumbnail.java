package com.tanguy.rssfeed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Thumbnail {
    @JsonProperty("url")
    public String url;
    @JsonProperty("title")
    public String title;
    @JsonProperty("link")
    public String link;
    @JsonProperty("width")
    public Integer width;
    @JsonProperty("height")
    public Integer height;

    public Thumbnail() {
        super();
    }
}