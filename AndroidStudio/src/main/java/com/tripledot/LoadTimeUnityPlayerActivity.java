package com.tripledot;

import java.util.concurrent.CopyOnWriteArraySet;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;

import com.unity3d.player.UnityPlayerActivity;

public class LoadTimeUnityPlayerActivity extends UnityPlayerActivity
{
    private static LoadTimeUnityPlayerActivity instance = null;
    public static LoadTimeUnityPlayerActivity getInstance() {
        return instance;
    }

    private static long onCreateTimestamp;

    @Override protected void onCreate(Bundle savedInstanceState) {
        Log.w("LoadTimeUnity", "onCreate");
        instance = this;
        onCreateTimestamp = System.currentTimeMillis();
        super.onCreate(savedInstanceState);
    }

    public static long timeSinceOnCreate() {
        return System.currentTimeMillis() - onCreateTimestamp;
    }
}