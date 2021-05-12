package com.example.gradle.twitter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Henry
 * @Date 2021/2/8  1:10 AM
 * @Email 2427417167@qq.com
 */
@Component(modules = NetworkModule.class)
interface ApiComponent {
    TwitterApi api();
}
