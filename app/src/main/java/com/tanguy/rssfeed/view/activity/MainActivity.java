package com.tanguy.rssfeed.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.RSSFeedApplication;
import com.tanguy.rssfeed.view.fragment.ChannelFragment;
import com.tanguy.rssfeed.view.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SharedPreferences sharedPreferences = RSSFeedApplication.getInstance().getSharedPreferences();
    private BottomNavigationView mBottomNav;
    private int mSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // If token doesn't exist, start LoginActivity
        if (sharedPreferences.getString("token", null) != null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
            mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
            mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    selectFragment(item);
                    return true;
                }
            });
            launchHomeFragment();
            //TODO faire quelque chose ici !
        }
    }

    private void selectFragment(MenuItem item) {
        Fragment frag = null;
        // init corresponding fragment
        switch (item.getItemId()) {
            case R.id.action_home:
                frag = HomeFragment.newInstance();
                break;
            case R.id.action_channel:
                frag = ChannelFragment.newInstance();
                break;
            case R.id.action_search:
//                frag = MenuFragment.newInstance(getString(R.string.text_search),
//                        getColorFromRes(R.color.color_search));
                break;
            case R.id.action_settings:
//                frag = MenuFragment.newInstance(getString(R.string.text_search),
//                        getColorFromRes(R.color.color_search));
                break;
        }

//         update selected item
        mSelectedItem = item.getItemId();

        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
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
        if (mSelectedItem != homeItem.getItemId()) {
            launchHomeFragment();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}