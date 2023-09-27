plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}
android {
    namespace = "com.example.firestore"
    compileSdk = 33
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
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
    implementation(Firebase.firestore)
}
