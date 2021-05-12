package com.example.gradle.twitter;

import android.util.Log;

import javax.inject.Inject;

/**
 * @author Henry
 * @Date 2021/2/6  1:49 PM
 * @Email 2427417167@qq.com
 */
public class TwitterApplication implements Runnable {
    private final Twitter twitter;
    private final   Timeline timeline;

    @Inject
    TwitterApplication(Twitter twitter,Timeline timeline){
        this.timeline = timeline;
        this.twitter = twitter;
    }



    @Override
    public void run() {
        Log.e("xia", "run: ");
    }
}
