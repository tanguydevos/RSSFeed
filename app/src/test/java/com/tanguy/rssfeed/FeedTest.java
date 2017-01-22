package com.tanguy.rssfeed;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanguy.rssfeed.model.Feed;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class FeedTest {
    @Test
    public void testJsonToFeed() throws Exception {
        String json = "{  \n" +
                "  \"title\": \"Feed title\",\n" +
                "  \"content\": \"Super content\",\n" +
                "  \"url\": \"//super.com/\",\n" +
                "  \"ttl\": 21231234\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        Feed feed = mapper.readValue(json, Feed.class);
        Assert.assertEquals("", "Feed title", feed.getTitle());
        Assert.assertEquals("", "Super content", feed.getContent());
        Assert.assertEquals("", "//super.com/", feed.getUrl());
        Assert.assertEquals("", "21231234", feed.getTTL());
    }

    @Test
    public void testFeedToJson() throws Exception {
        Feed feed = new Feed("Feed title", "Super content", "//super.com", "21231234");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(feed);
        Assert.assertEquals("", "{\"title\":\"Feed title\",\"content\":\"Super content\",\"url\":\"//super.com\",\"ttl\":\"21231234\"}", json);
    }
}
