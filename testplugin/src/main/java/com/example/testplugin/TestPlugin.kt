package com.example.testplugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class TestPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val appExtension = project.extensions.findByType(AppExtension::class.java)
        val andExt = project.extensions.create("AndExt", AndExt::class.java)
        appExtension?.registerTransform(AndExtTransform(appExtension, andExt))
    }
}