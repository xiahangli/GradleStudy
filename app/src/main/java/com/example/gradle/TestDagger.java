package com.example.gradle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
//
//import androidx.annotation.NonNull;


/**
 * @author Henry
 * @Date 2021/2/6  2:33 PM
 * @Email 2427417167@qq.com
 */
public class TestDagger extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Looper looper = Looper.myLooper();
        Handler handler =new Handler(looper,(msg)-> {
            System.out.println();
            return false;
        });
        new Thread(){
            @Override
            public void run() {
                Looper.prepare();
                Looper looper1 = Looper.myLooper();
                System.out.println();
                Looper.loop();
            }
        }.start();
        handler.sendEmptyMessage(123);
//        TwitterComponent component = DaggerTwitterComponent.builder().networkModule(new NetworkModule())
//                .twitterModule(new TwitterModule("xiahangli"))
//                .build();
//        component.timeline().loadMore(123);
//        component.twitter().tweet("helloworld");
//        TwitterApplication app = component.app();
//        app.run();

    }
}
