package com.example.gradle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
//
//import androidx.annotation.NonNull;
//import com.jakewharton.threetenabp.AndroidThreeTen;
//import org.threeten.bp.chrono.AbstractChronology;
//import org.threeten.bp.chrono.ChronoLocalDate;
//import org.threeten.bp.chrono.Era;
//import org.threeten.bp.temporal.ChronoField;
//import org.threeten.bp.temporal.TemporalAccessor;
//import org.threeten.bp.temporal.ValueRange;

import java.time.chrono.AbstractChronology;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Era;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ValueRange;
import java.util.List;

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
//        AbstractChronology a = new AbstractChronology() {
//            @Override
//            public String getId() {
//                return null;
//            }
//
//            @Override
//            public String getCalendarType() {
//                return null;
//            }
//
//            @Override
//            public ChronoLocalDate date(int i, int i1, int i2) {
//                return null;
//            }
//
//            @Override
//            public ChronoLocalDate dateYearDay(int i, int i1) {
//                return null;
//            }
//
//            @Override
//            public ChronoLocalDate dateEpochDay(long l) {
//                return null;
//            }
//
//            @Override
//            public ChronoLocalDate date(TemporalAccessor temporalAccessor) {
//                return null;
//            }
//
//            @Override
//            public boolean isLeapYear(long l) {
//                return false;
//            }
//
//            @Override
//            public int prolepticYear(Era era, int i) {
//                return 0;
//            }
//
//            @Override
//            public Era eraOf(int i) {
//                return null;
//            }
//
//            @Override
//            public List<Era> eras() {
//                return null;
//            }
//
//            @Override
//            public ValueRange range(ChronoField chronoField) {
//                return null;
//            }
//        };
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
