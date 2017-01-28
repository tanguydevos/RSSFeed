package com.tanguy.rssfeed;


import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.util.Log;

import com.tanguy.rssfeed.service.RetrofitFactory;

public class RSSFeedApplication extends Application {

    private static RSSFeedApplication mAppInstance;
    public static RetrofitFactory retrofitFactory;
    public static SharedPreferences sharedPreferences;

    // Singleton
    public static RSSFeedApplication getInstance() {
        if (mAppInstance == null) {
            synchronized (RSSFeedApplication.class) {
                if (mAppInstance == null) {
                    mAppInstance = new RSSFeedApplication();
                }
            }
        }
        return mAppInstance;
    }

    public RetrofitFactory getRetrofitFactory() {
        return retrofitFactory;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Save the instances
        retrofitFactory = new RetrofitFactory();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mAppInstance = this;

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