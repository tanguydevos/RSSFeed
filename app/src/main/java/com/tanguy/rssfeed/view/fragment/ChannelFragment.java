package com.tanguy.rssfeed.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.model.Channel;
import com.tanguy.rssfeed.view.adapter.ChannelAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChannelFragment extends Fragment {

    private List<Channel> channels = new ArrayList<>();
    private RecyclerView recyclerView;
    private ChannelAdapter channelAdapter;

    public static Fragment newInstance() {
        return new ChannelFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.channel_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        channelAdapter = new ChannelAdapter(channels);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(channelAdapter);

        prepareMovieData();

        // retrieve text and color from bundle or savedInstanceState
        if (savedInstanceState == null) {
        } else {
        }

    }

    private void prepareMovieData() {
        Channel test = new Channel();
        test.title = "Basket USA";
        test.description = "Le site d'actualité français de la NBA";
        test.article_number = 42;
        channels.add(test);
        channels.add(test);
        channels.add(test);
        channels.add(test);
        channels.add(test);
        channels.add(test);
        channels.add(test);
        channels.add(test);
        channels.add(test);

        channelAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}