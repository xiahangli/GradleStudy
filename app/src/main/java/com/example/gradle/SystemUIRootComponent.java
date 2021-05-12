package com.example.gradle;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
//        SystemUIFactory.class,
        DependencyProvider.class,
//        DependencyBinder.class,
        SystemUIFactory.ContextHolder.class
})
public interface SystemUIRootComponent {
//    @Singleton
//    Dependency.DependencyInjector createDependency();
}