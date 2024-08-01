// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    id("com.apollographql.apollo3") version "3.8.5" apply false
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies{
        classpath(libs.realm.gradle.plugin)
        classpath(libs.apollo.plugin)
    }
}