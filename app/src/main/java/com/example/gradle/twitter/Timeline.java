package com.example.gradle.twitter;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Henry
 * @Date 2021/2/6  2:16 PM
 * @Email 2427417167@qq.com
 */
public class Timeline {
    private final TwitterApi api;
    private final String user;

    @Inject
    public Timeline(TwitterApi api, String user) {
        this.user=user;
        this.api= api;
    }

    public void loadMore(int num){
        api.loadMore(num);
    }
}
