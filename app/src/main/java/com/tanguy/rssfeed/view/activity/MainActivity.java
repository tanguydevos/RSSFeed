package com.tanguy.rssfeed.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.RSSFeedApplication;
import com.tanguy.rssfeed.view.fragment.AddChannelFragment;
import com.tanguy.rssfeed.view.fragment.ChannelFragment;
import com.tanguy.rssfeed.view.fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    static final int LOGGED = 1;  // The request code
    private static final String TAG = "MainActivity";
    private SharedPreferences sharedPreferences = RSSFeedApplication.getInstance().getSharedPreferences();
    private BottomNavigationView mBottomNav;
    private int mSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the layout for MainActivity
        setContentView(R.layout.activity_main);
        // Init the bottom navigation view to select appropriate fragment on click
        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });
        // If token doesn't exist, start LoginActivity
        if (!sharedPreferences.getBoolean("rememberMe", true)
                || sharedPreferences.getString("token", null) == null) {
            Intent i = new Intent(this, LoginActivity.class);
            startActivityForResult(i, 1);
        } else {
            // Launch by default the home fragment
            launchHomeFragment();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == LOGGED) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                launchHomeFragment();
            }
        }
    }

    private void selectFragment(MenuItem item) {
        Fragment frag = null;
        // init corresponding fragment
        switch (item.getItemId()) {
            case R.id.action_home:
                frag = ChannelFragment.newInstance();
                break;
            case R.id.action_search:
                frag = AddChannelFragment.newInstance();
                break;
            case R.id.action_settings:
                frag = SettingsFragment.newInstance();
                break;
        }
        //  update selected item
        mSelectedItem = item.getItemId();
        if (frag != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.container, frag, frag.getTag());
            ft.commit();
        }
    }

    private void launchHomeFragment() {
        mBottomNav.getMenu().getItem(0).setChecked(true);
        mBottomNav.getMenu().performIdentifierAction(R.id.action_home, 0);
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
        // Go back to HomeFragment if return button is pressed on a different fragment
        if (mSelectedItem != homeItem.getItemId()) {
            launchHomeFragment();
        } else {
            // Default behaviour
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}