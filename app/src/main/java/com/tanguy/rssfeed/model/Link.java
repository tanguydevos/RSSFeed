package com.tanguy.rssfeed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Link {
    @JsonProperty("href")
    public String href;
    @JsonProperty("rel")
    public String rel;
    @JsonProperty("link")
    public String link;
    @JsonProperty("content_type")
    public String content_type;
}