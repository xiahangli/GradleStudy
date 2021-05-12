package com.example.gradle.twitter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Henry
 * @Date 2021/2/6  2:13 PM
 * @Email 2427417167@qq.com
 */
@Module
public class TwitterModule {
    private final String user;

    public TwitterModule(String user) {
        this.user = user;
    }


    @Provides
//@Singleton
    Twitter provideTwitter(TwitterApi api) {
        return new Twitter(api, user);
    }

    @Provides
    Timeline provideTimeline(TwitterApi api) {
        return new Timeline(api, user);
    }
}
