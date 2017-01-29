package com.tanguy.rssfeed.service;

import com.tanguy.rssfeed.model.Feed;

import java.util.List;

public interface CallBackFeed {
    void getFeedsSuccess(List<Feed> channels);

    void getFeedsError(List<Feed> channels);
}
