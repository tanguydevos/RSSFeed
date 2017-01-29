package com.tanguy.rssfeed.view.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.databinding.AddChannelFragmentBinding;
import com.tanguy.rssfeed.viewModel.AddChannelViewModel;

public class AddChannelFragment extends Fragment {

    public static Fragment newInstance() {
        return new AddChannelFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_channel_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AddChannelFragmentBinding binding = DataBindingUtil.setContentView(getActivity(), R.layout.add_channel_fragment);
        AddChannelViewModel addChannelViewModel = new AddChannelViewModel(getActivity());
        binding.setAddChannelViewModel(addChannelViewModel);
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