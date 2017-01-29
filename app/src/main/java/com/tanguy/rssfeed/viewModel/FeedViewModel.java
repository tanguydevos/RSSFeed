package com.tanguy.rssfeed.viewModel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.RSSFeedApplication;
import com.tanguy.rssfeed.model.Feed;
import com.tanguy.rssfeed.service.CallBackFeed;
import com.tanguy.rssfeed.service.RecyclerViewClickListener;
import com.tanguy.rssfeed.service.RetrofitFactory;
import com.tanguy.rssfeed.view.adapter.FeedAdapter;

import java.util.List;

public class FeedViewModel implements CallBackFeed, RecyclerViewClickListener {
    private static final String TAG = "ChannelViewModel";
    private static final RetrofitFactory retrofitFactory = RSSFeedApplication.getInstance().getRetrofitFactory();
    private RecyclerView recyclerView;
    private Context context;
    private ProgressBar progressBar;
    private List<Feed> feeds;

    public FeedViewModel(Context context, RecyclerView recyclerView, ProgressBar progressBar) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.progressBar = progressBar;
        retrofitFactory.getChannel(this, 4);
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(feeds.get(0).link));
        context.startActivity(browserIntent);
    }

    public void getFeedsSuccess(List<Feed> feedList) {
        feeds = feedList;
        progressBar.setVisibility(View.GONE);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        FeedAdapter feedAdapter = new FeedAdapter(feeds, this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(feedAdapter);
    }

    public void getFeedsError(List<Feed> feeds) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(context, context.getString(R.string.serverNotReachable), Toast.LENGTH_SHORT).
                show();
    }
}
