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
        holder.description.setText(channel.description);
        holder.articleNumber.setText(String.valueOf(channel.article_number));
    }

    @Override
    public int getItemCount() {
        return channelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, articleNumber, description;

        MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
            articleNumber = (TextView) view.findViewById(R.id.article_number);
        }
    }
}