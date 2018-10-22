package com.tripledot;

import android.util.Log;

// For multidex to work android versions prior to 5.0 we need to subclass from MultiDexApplication class
public class StartupTimeApplication extends android.support.multidex.MultiDexApplication
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