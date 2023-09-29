import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    kotlin("android")
    kotlin("kapt")
}
android {
    namespace = "com.example.domain"
    compileSdk = 33
    defaultConfig {
        minSdk = 23
        targetSdk = 33
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
dependencies {
    implementation(Kotlin.kotlin_stdlib)
    // Test
    testImplementation(Testing.jUnit)
    androidTestImplementation(Testing.test_jUnit)
    androidTestImplementation(Testing.test_espresso)
    // Dagger Hilt
    implementation(DaggerHilt.hilt_android)
    kapt(DaggerHilt.hilt_android_compiler)
    kapt(DaggerHilt.hilt_compiler)
    // Coroutines
    implementation(Coroutines.android)
    implementation(Coroutines.core)
    api(project(":data"))
}
