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

    @Override protected void onCreate(Bundle savedInstanceState) {
        Log.w("LoadTimeUPA", "onCreate");
        instance = this;
        super.onCreate(savedInstanceState);
    }
}