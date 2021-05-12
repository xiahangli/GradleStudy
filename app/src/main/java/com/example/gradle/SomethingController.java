package com.example.gradle;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Provides;

/**
 * @author Henry
 * @Date 2021/2/6  12:54 PM
 * @Email 2427417167@qq.com
 */
@Singleton
public class SomethingController<T> {
    private static final String TAG = "xia";

    public SomethingController() {
    }

    @Inject
    public SomethingController(Context context, @Named("main_handler_name") Handler mainHandler){
        Log.e(TAG, "SomethingController: ");
        List<String> s = null;
//        List<Object> objects = s;
        List objects1 = s;
//        t = boolean.class;
        List<String> ss = new ArrayList<>();
//        addNewObject(ss);
        Class<? extends List> aClass = new ArrayList<String>().getClass();

        List <String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        System.out.println(l1.getClass() == l2.getClass());
//        klazz =
    }



    void addNewObject(List<Object> objects){
        objects.add(new Object());
        objects.add(new String());
    }


//    @Provides
//   public  SomethingController provideSomethingController(){
//        // context and mainHandler will be automatically populated.
//        return new SomethingController()
//    }
}
