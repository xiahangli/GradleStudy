/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.example.gradle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.util.ArrayMap;
import android.util.Log;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.Subcomponent;


/**
 * Class to handle ugly dependencies throughout sysui until we determine the
 * long-term dependency injection solution.
 * <p>
 * Classes added here should be things that are expected to live the lifetime of sysui,
 * and are generally applicable to many parts of sysui. They will be lazily
 * initialized to ensure they aren't created on form factors that don't need them
 * (e.g. HotspotController on TV). Despite being lazily initialized, it is expected
 * that all dependencies will be gotten during sysui startup, and not during runtime
 * to avoid jank.
 * <p>
 * All classes used here are expected to manage their own lifecycle, meaning if
 * they have no clients they should not have any registered resources like bound
 * services, registered receivers, etc.
 */
public class Dependency {

    /**
     * Key for getting a background Looper for background work.
     */
    public static final DependencyKey<Looper> BG_LOOPER = new DependencyKey<>("background_looper");
    /**
     * Key for getting a Handler for receiving time tick broadcasts on.
     */
    public static final DependencyKey<Handler> TIME_TICK_HANDLER =
            new DependencyKey<>("time_tick_handler");
    /**
     * Generic handler on the main thread.
     */
    public static final DependencyKey<Handler> MAIN_HANDLER = new DependencyKey<>("main_handler");

    /**
     * An email address to send memory leak reports to by default.
     */
    public static final DependencyKey<String> LEAK_REPORT_EMAIL = new DependencyKey<>("leak_report_email");

    @SuppressLint("NewApi")
    private final ArrayMap<Object, Object> mDependencies = new ArrayMap<>();
    private final ArrayMap<Object, DependencyProvider> mProviders = new ArrayMap<>();

    private long a = 1234;
    private long SOME_FLAG = 0x01;//bit flagsssssssw

    public void setFlag(int flag) {
        a |= flag;
    }

    @Inject
    Lazy<SomethingController> somethingControllerLazy;

//    Lazy<SomethingController> somethingControllerProvider = ()->{
//        return new SomethingController(null,null);
//    };


    /**
     * <blockquote><pre>
     *     this is blockquote
     *     </pre>
     * </blockquote>
     * <p> this is paragraph
     * <p> it's another paragraph
     * <p> it's third paragraph
     * <p>
     *     {@code enum}
     * the {@link Context#getAssets() getAssets} method   }
     * <br>
     *     asdfjsldf
     *
     */
    public void start() {
//        try {
//            Thread.sleep(10*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        sDependency = this;
        Class<? extends Object>  t = SomethingController.class;

        try {
            SomethingController o = (SomethingController) t.newInstance();
            ClassLoader classLoader = t.getClassLoader();
            classLoader.loadClass("");
            System.out.println();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        mProviders.put(SomethingController.class, () -> {
            return new SomethingController(null, null);
        });


        // TODO: Think about ways to push these creation rules out of Dependency to cut down
        // on imports.
//        mProviders.put(TIME_TICK_HANDLER, () -> {
//            MyHandlerThread thread = new MyHandlerThread("TimeTick");
//            /*Thread xia = new Thread() {
//                @Override
//                public void run() {
//                    thread.start();
//                            super.run();
//                    synchronized (this){
//                        while (true) {
//                            if (isInterrupted()){
//                                boolean interrupted = interrupted();
//                                Log.e("xia", "run2: "+interrupted);
//
//                            }else{
//                                Log.e("xia", "run1: ");
//                            }
//                            try {
//                                this.wait(20000L);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                                boolean interrupted = Thread.currentThread().isInterrupted();
//                                boolean interrupted1 = Thread.currentThread().interrupted();
//                                boolean interrupted2 = Thread.currentThread().isInterrupted();
//
//                                Log.e("xia", "run: 1111111");
//                            }
//                        }
//                    }
//
//                }
//            };*/
//           /* xia.start();
//
//            final Handler handler = new Handler(thread.getLooper());
//            try {
//                Log.e("xia", "main thread sleep ok start11111: ");
//                Thread.sleep(2*1000);
//                xia.interrupt();
//                Log.e("xia", "main thread sleep ok start: ");
//            }catch(InterruptedException e){
//                e.printStackTrace();
//                Log.e("xia", "start: ");
//            }*/
////            thread.interrupt();
//            return thread;
//        });
//        mProviders.put(BG_LOOPER, () -> {
//            HandlerThread thread = new HandlerThread("SysUiBg",
//                    Process.THREAD_PRIORITY_BACKGROUND);
//            thread.start();
//            return thread.getLooper();
//        });
//        mProviders.put(MAIN_HANDLER, () -> new Handler(Looper.getMainLooper()));


        // Put all dependencies above here so the factory can override them if it wants.
//        SystemUIFactory.getInstance().injectDependencies(mProviders, mContext);
    }

//    @Override
//    public synchronized void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
//        super.dump(fd, pw, args);
//        pw.println("Dumping existing controllers:");
//        mDependencies.values().stream().filter(obj -> obj instanceof Dumpable)
//                .forEach(o -> ((Dumpable) o).dump(fd, pw, args));
//    }


    protected final <T> T getDependency(Class<T> cls) {
        return getDependencyInner(cls);
    }

    protected final <T> T getDependency(DependencyKey<T> key) {
        return getDependencyInner(key);
    }

    private synchronized <T> T getDependencyInner(Object key) {
        @SuppressWarnings("unchecked")
        T obj = (T) mDependencies.get(key);
        if (obj == null) {
            obj = createDependency(key);
            mDependencies.put(key, obj);
        }
        return obj;
    }

    protected <T> T createDependency(Object cls) {

//        Preconditions.checkArgument(cls instanceof DependencyKey<?> || cls instanceof Class<?>);

        @SuppressWarnings("unchecked")
        DependencyProvider<T> provider = mProviders.get(cls);
        if (provider == null) {
            throw new IllegalArgumentException("Unsupported dependency " + cls);
        }
        return provider.createDependency();
    }

    private static Dependency sDependency;

    public interface DependencyProvider<T> {
        T createDependency();
    }


    public static <T> T get(Class<T> cls) {
        return sDependency.getDependency(cls);
    }

    public static <T> T get(DependencyKey<T> cls) {
        return sDependency.getDependency(cls);
    }

    public static final class DependencyKey<V> {
        private final String mDisplayName;

        public DependencyKey(String displayName) {
            mDisplayName = displayName;
        }

        @Override
        public String toString() {
            return mDisplayName;
        }
    }

    @Subcomponent
  interface  DependencyInjector{
        void createSystemUI(Dependency dependency);
  }
}
