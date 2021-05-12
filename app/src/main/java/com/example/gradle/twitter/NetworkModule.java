package com.example.gradle.twitter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * @author Henry
 * @Date 2021/2/6  2:19 PM
 * @Email 2427417167@qq.com
 */
@Module
public class NetworkModule {
    @Provides
   OkHttpClient provideOkhttp(){
        return new OkHttpClient();
    }

    @Provides
   TwitterApi provideTwitterApi(OkHttpClient client){
        return new TwitterApi(client);
    }
}
