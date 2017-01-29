package com.tanguy.rssfeed.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.tanguy.rssfeed.R;


public class SettingsFragment extends PreferenceFragment {
    private static final String TAG = "SettingsFragment";

    public static Fragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }

}
