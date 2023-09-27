plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.gms.google-services")
}
android {
    namespace = "com.javiermtz.storitest"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.javiermtz.storitest"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}
val composeVersion =
    rootProject.extra.get("compose_version") as String
dependencies {
    implementation(Kotlin.kotlin_stdlib)
    // Core
    implementation(AndroidX.core_ktx)
    // Compose
    implementation(AndroidX.activity_compose)
    implementation(AndroidX.compose_ui)
    implementation(AndroidX.ui_tooling_preview)
    implementation(AndroidX.compose_material)
    implementation(AndroidX.compose_material_icons)
    implementation(Navigation.navigation_compose)
    // Lifecycle
    implementation(Lifecycle.runtime_ktx)
    implementation(Lifecycle.viewmodel_kts)
    implementation(Lifecycle.viewmodel_compose)
    // Test
    testImplementation(Testing.jUnit)
    androidTestImplementation(Testing.test_jUnit)
    androidTestImplementation(Testing.test_espresso)
    androidTestImplementation(Testing.compose_ui_jUnit)
    debugImplementation(Testing.compose_ui_tooling)
    debugImplementation(Testing.compose_ui_manifest)
    androidTestImplementation(Testing.hilt)
    testImplementation(Testing.hilt)
    kaptAndroidTest(Testing.hilt_android)
    testImplementation(Testing.mock)
    testImplementation(Testing.coroutines)
    testImplementation(Testing.core)
    testImplementation(Testing.truth)
    // Dagger Hilt
    implementation(DaggerHilt.hilt_android)
    implementation(DaggerHilt.hilt_navigation)
    kapt(DaggerHilt.hilt_android_compiler)
    kapt(DaggerHilt.hilt_compiler)
    // Coroutines
    implementation(Coroutines.android)
    implementation(Coroutines.core)
    // Coil
    implementation(Coil.coil)
    implementation(Coil.coil_compose)
    // Firebase
    implementation(platform(Firebase.bom))
    implementation(Firebase.auth_ktx)
}
