package com.tanguy.rssfeed.viewModel;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.RSSFeedApplication;
import com.tanguy.rssfeed.model.Channel;
import com.tanguy.rssfeed.service.CallBackChannel;
import com.tanguy.rssfeed.service.RecyclerViewClickListener;
import com.tanguy.rssfeed.service.RetrofitFactory;
import com.tanguy.rssfeed.view.adapter.ChannelAdapter;
import com.tanguy.rssfeed.view.fragment.FeedFragment;

import java.util.List;

public class ChannelViewModel implements CallBackChannel, RecyclerViewClickListener {
    private static final String TAG = "ChannelViewModel";
    private static final RetrofitFactory retrofitFactory = RSSFeedApplication.getInstance().getRetrofitFactory();
    private static final SharedPreferences sharedPreferences = RSSFeedApplication.getInstance().getSharedPreferences();
    private RecyclerView recyclerView;
    private Context context;
    private List<Channel> channelList;
    private ProgressBar progressBar;

    public ChannelViewModel(Context context, RecyclerView recyclerView, ProgressBar progressBar) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.progressBar = progressBar;
        retrofitFactory.getChannels(this, sharedPreferences.getString("token", null));
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        System.out.println(position);
        Fragment FeedFragment = new FeedFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", channelList.get(position).id);
        FeedFragment.setArguments(bundle);
        FragmentTransaction ft = ((Activity) context).getFragmentManager().beginTransaction();
        ft.replace(R.id.container, FeedFragment, FeedFragment.getTag());
        ft.commit();
    }

    public void getChannelsSuccess(List<Channel> channels) {
        channelList = channels;
        progressBar.setVisibility(View.GONE);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        ChannelAdapter channelAdapter = new ChannelAdapter(channels, this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(channelAdapter);
    }

    public void getChannelsError(List<Channel> channels) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(context, context.getString(R.string.serverNotReachable), Toast.LENGTH_SHORT).
                show();
    }
}
