package com.example.gradle.twitter;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Henry
 * @Date 2021/2/6  2:14 PM
 * @Email 2427417167@qq.com
 */
public class Twitter {

    private final TwitterApi api;
    private final String user;


//    @Inject
    public Twitter(TwitterApi api, String user) {
        this.api = api;
        this.user = user;
    }

    public void tweet(String content){
        api.postTwitter(content,user);
    }
}
