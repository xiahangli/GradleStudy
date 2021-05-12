package com.example.gradle;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Henry
 * @Date 2021/2/6  12:57 PM
 * @Email 2427417167@qq.com
 */
@Module
class DependencyProvider {

    @Singleton
    @Provides
    public SomethingController provideSomethingController(Context context,@Named("main_thread_handler") Handler mainHandler){
        Log.e("xia", "provideSomethingController: ");
        return new SomethingControllerImpl(context,mainHandler);
    }
}
