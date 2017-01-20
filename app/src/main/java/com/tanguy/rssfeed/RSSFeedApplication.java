package com.tanguy.rssfeed;


import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

public class RSSFeedApplication extends Application {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("RSSFeedApplication", "onCreate");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d("RSSFeedApplication", "onLowMemory");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d("RSSFeedApplication", "onTerminate");
    }

}