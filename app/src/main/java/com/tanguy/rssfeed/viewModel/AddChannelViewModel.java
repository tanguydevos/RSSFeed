package com.tanguy.rssfeed.viewModel;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.RSSFeedApplication;
import com.tanguy.rssfeed.service.CallBackAddChannel;
import com.tanguy.rssfeed.service.RetrofitFactory;

public class AddChannelViewModel implements CallBackAddChannel {
    private static final String TAG = "AddChannelViewModel";
    private Context context;
    private String rssLink;
    private RetrofitFactory retrofitFactory = RSSFeedApplication.getInstance().getRetrofitFactory();
    private SharedPreferences sharedPreferences = RSSFeedApplication.getInstance().getSharedPreferences();

    public AddChannelViewModel(Context context) {
        this.context = context;
    }

    public void addSuccess() {
        Toast.makeText(context, context.getString(R.string.addedRss), Toast.LENGTH_SHORT).
                show();
    }

    public void addError() {
        Toast.makeText(context, context.getString(R.string.serverNotReachable), Toast.LENGTH_SHORT).
                show();
    }

    public void submit(View view) {
        // Validate rssLink before try send it
        if (this.rssLink != null && !this.rssLink.isEmpty()) {
            retrofitFactory.addChannel(this, sharedPreferences.getString("token", null), rssLink);
        } else {
            Snackbar.make(view, R.string.missingParameters, Snackbar.LENGTH_LONG)
                    .setDuration(Snackbar.LENGTH_SHORT).show();
        }
    }

    public String getRssLink() {
        return this.rssLink;
    }

    public void setRssLink(String rssLink) {
        this.rssLink = rssLink;
    }

}
