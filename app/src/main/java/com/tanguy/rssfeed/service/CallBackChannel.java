package com.tanguy.rssfeed.service;

import com.tanguy.rssfeed.model.Channel;

import java.util.List;

public interface CallBackChannel {
    void getChannelsSuccess(List<Channel> channels);

    void getChannelsError(List<Channel> channels);
}
