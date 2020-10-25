package com.example.musicshop.test;

import android.util.Log;

public class Magnitola implements Player {
    private static final String TAG = "Magnitola";
    @Override
    public void play()
    {
        Log.e(TAG, "play: in car" );
    }
}
