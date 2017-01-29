package com.tanguy.rssfeed.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.model.Feed;
import com.tanguy.rssfeed.view.adapter.FeedAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    private List<Feed> feeds = new ArrayList<>();
    private FeedAdapter feedAdapter;

    public static Fragment newInstance() {
        return new HomeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        feedAdapter = new FeedAdapter(feeds);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(feedAdapter);

        prepareMovieData();

        // retrieve text and color from bundle or savedInstanceState
        if (savedInstanceState == null) {
        } else {
        }

    }

    private void prepareMovieData() {
        Feed test = new Feed();
        Feed test2 = new Feed();
        test.title = "Le meilleur match en carrière pour Carmelo Anthony !";
        test.content = "C'était une soirée folle hier au Madison Square Garden où a eu lieu une performance à peine croyable de Carmelo Anthony";
        test.url = "http://lightthemup.fr.nf/";
        feeds.add(test);
        test2.title = "Happy birthday Laurie";
        test2.content = "Ma meilleure amie";
        test2.url = "http://lightthemup.fr.nf/";
        feeds.add(test2);
        feeds.add(test);
        feeds.add(test2);
        feeds.add(test2);
        feeds.add(test);
        feeds.add(test);
        feeds.add(test);
        feeds.add(test);

        feedAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}