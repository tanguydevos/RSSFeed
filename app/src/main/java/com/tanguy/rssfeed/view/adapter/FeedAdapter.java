package com.tanguy.rssfeed.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.model.Feed;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {

    private List<Feed> feedList;

    public FeedAdapter(List<Feed> feedList) {
        this.feedList = feedList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Feed feed = feedList.get(position);
        holder.title.setText(feed.title);
        holder.content.setText(feed.content);
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, content;

        MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.description);
        }
    }
}