plugins {
    alias(libs.plugins.android.application)
    id("realm-android")
    id("com.apollographql.apollo3")
}

android {
    namespace = "recommender.recommenderui"
    compileSdk = 34

    defaultConfig {
        applicationId = "recommender.recommenderui"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.okhttp)
    implementation(libs.realm.gradle.plugin)
    implementation(libs.gson)
    implementation(libs.apollo)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

apollo {
    service("service") {
        packageName.set("recommender.recommenderui.controller.backend.graphqlFiles.storage")

    }
}