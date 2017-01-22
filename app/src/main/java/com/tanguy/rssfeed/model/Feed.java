package com.tanguy.rssfeed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feed {
    @JsonProperty("title")
    private String mTitle;
    @JsonProperty("content")
    private String mContent;
    @JsonProperty("url")
    private String mUrl;
    @JsonProperty("ttl")
    private String mTTL;

    public Feed() {
        super();
    }

    public Feed(String title, String content, String url, String ttl) {
        this.mTitle = title;
        this.mContent = content;
        this.mUrl = url;
        this.mTTL = ttl;
    }

    /**
     * @return The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return mTitle;
    }

    /**
     * @return The content
     */
    @JsonProperty("content")
    public String getContent() {
        return mContent;
    }

    /**
     * @return The URL
     */
    @JsonProperty("url")
    public String getUrl() {
        return mUrl;
    }

    /**
     * @return The TTL
     */
    @JsonProperty("ttl")
    public String getTTL() {
        return mTTL;
    }
}