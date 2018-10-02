package com.tripledot;

import android.app.Application;
import android.util.Log;

public class StartupTimeApplication extends Application
{
    private static StartupTimeApplication instance = null;
    public static StartupTimeApplication getInstance() {
        return instance;
    }

    private static long onCreateTimestamp;

    @Override public void onCreate() {
        Log.w("StartupTimeApplication", "onCreate");
        instance = this;
        onCreateTimestamp = System.currentTimeMillis();
        super.onCreate();
    }

    public static long timeSinceOnCreate(String tag) {
        long result = System.currentTimeMillis() - onCreateTimestamp;
        Log.w("StartupTimeApplication", "timeSinceOnCreate - " + result + " - " + tag);
        return result;
    }
}