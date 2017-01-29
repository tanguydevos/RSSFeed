package com.tanguy.rssfeed.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.model.Channel;

import java.util.List;

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.MyViewHolder> {

    private List<Channel> channelList;

    public ChannelAdapter(List<Channel> channelList) {
        this.channelList = channelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.channel_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Channel channel = channelList.get(position);
        holder.title.setText(channel.title);
        holder.genre.setText(channel.description);
        holder.year.setText(String.valueOf(channel.article_number));
    }

    @Override
    public int getItemCount() {
        return channelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, year, genre;

        MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.description);
            year = (TextView) view.findViewById(R.id.article_number);
        }
    }
}