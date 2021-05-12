package com.example.gradle.twitter;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author Henry
 * @Date 2021/2/6  2:11 PM
 * @Email 2427417167@qq.com
 */
public class TwitterApi {

    OkHttpClient client;

    @Inject
    TwitterApi(OkHttpClient client){
        this.client = client;
    }

    void postTwitter(String tweet,String user){
//        client.newCall(new Request()).execute();
        Log.e("xia", "postTwitter: ");
    }

    void loadMore(int num){
        Log.e("xia", "loadMore: "+num);
    }
}
