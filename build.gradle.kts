// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.hilt) apply false

    //alias(libs.plugins.ksp) apply false

//    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
}