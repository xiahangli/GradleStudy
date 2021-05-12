package com.example.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project;

public class MyPlugin1 implements Plugin<Project> {
    @Override
    void apply(Project target) {
        print("apply")

        if (target.plugins.hasPlugin("com.android.application")) {
            print("has com.android.application")
        }


    }
}