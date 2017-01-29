package com.tanguy.rssfeed.viewModel;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tanguy.rssfeed.RSSFeedApplication;
import com.tanguy.rssfeed.model.Channel;
import com.tanguy.rssfeed.service.CallBackChannel;
import com.tanguy.rssfeed.service.RetrofitFactory;
import com.tanguy.rssfeed.view.adapter.ChannelAdapter;

import java.util.List;

public class ChannelViewModel implements CallBackChannel {
    private static final String TAG = "ChannelViewModel";
    private static final RetrofitFactory retrofitFactory = RSSFeedApplication.getInstance().getRetrofitFactory();
    private static final SharedPreferences sharedPreferences = RSSFeedApplication.getInstance().getSharedPreferences();
    private RecyclerView recyclerView;
    private Context context;
    private Channel channel;

    public ChannelViewModel(Context context, RecyclerView recyclerView) {
        this.context = context;
        this.channel = new Channel();
        this.recyclerView = recyclerView;
        retrofitFactory.getChannels(this, sharedPreferences.getString("token", null));
    }

    public void getChannelsSuccess(List<Channel> channels) {
        ChannelAdapter channelAdapter = new ChannelAdapter(channels);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(channelAdapter);
    }

    public void getChannelsError(List<Channel> channels) {

    }
}
