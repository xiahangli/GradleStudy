package com.example.gradle.twitter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Henry
 * @Date 2021/2/6  1:31 PM
 * @Email 2427417167@qq.com
 */
@Component(dependencies = ApiComponent.class,modules = {TwitterModule.class})
public interface TwitterComponent {
//   TwitterApi api();
   TwitterApplication app( );
//   Twitter twitter();
//   Timeline timeline();
}
