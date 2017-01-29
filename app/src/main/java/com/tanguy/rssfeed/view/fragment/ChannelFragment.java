package com.tanguy.rssfeed.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.viewModel.ChannelViewModel;

public class ChannelFragment extends Fragment {

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

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        ChannelViewModel channelViewModel = new ChannelViewModel(getActivity(), recyclerView);

        // retrieve text and color from bundle or savedInstanceState
        if (savedInstanceState == null) {
        } else {
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}