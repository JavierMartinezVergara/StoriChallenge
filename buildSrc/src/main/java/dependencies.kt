object Versions {
    val kts_core = "1.9.0"
    val hilt = "2.44.2"
    val hilt_navigation = "1.0.0"
    val hilt_compiler = "1.0.0"
    val coroutines = "1.3.5"
    val coroutines_test = "1.6.4"
    val navigation = "2.5.3"
    val lifecycle = "2.6.0-alpha05"
    val coil = "1.3.2"
    val coil_compose = "2.0.0-rc01"
    val kotlin_stdlib = "1.8.10"
    val activity_compose = "1.6.1"
    val compose = "1.3.3"
    val compose_material = "1.3.1"
    val firebase_bom = "31.2.0"
    val firebase_auth = "21.1.0"
    val mock = "1.10.6"
    val truth = "1.1.2"
    val jUnit = "4.13.2"
    val test_jUnit = "1.1.5"
    val espresso_core = "3.5.1"
    val compose_test_jUnit = "1.3.3"
    val core_test = "2.1.0"
    val firestore = "24.4.3"
    val mockito = "4.1.0"
    val datastore = "1.0.0"
    val one_signal = "[4.0.0, 4.99.99]"
}

object Testing {
    val jUnit = "junit:junit:" + Versions.jUnit
    val test_jUnit = "androidx.test.ext:junit:" + Versions.test_jUnit
    val test_espresso = "androidx.test.espresso:espresso-core:" + Versions.espresso_core
    val compose_ui_jUnit = "androidx.compose.ui:ui-test-junit4:" + Versions.compose
    val compose_ui_tooling = "androidx.compose.ui:ui-tooling:" + Versions.compose
    val compose_ui_manifest = "androidx.compose.ui:ui-test-manifest:" + Versions.compose
    val hilt = "com.google.dagger:hilt-android-testing:" + Versions.hilt
    val hilt_android = "com.google.dagger:hilt-android-compiler:" + Versions.hilt
    val mock = "io.mockk:mockk:" + Versions.mock
    val truth = "com.google.truth:truth:" + Versions.truth
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:" + Versions.coroutines_test
    val core = "androidx.arch.core:core-testing:" + Versions.core_test
}

object Kotlin {
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:" + Versions.kotlin_stdlib
}

object Coil {
    val coil = "io.coil-kt:coil:" + Versions.coil
    val coil_compose = "io.coil-kt:coil-compose:" + Versions.coil_compose
}

object AndroidX {
    val activity_compose = "androidx.activity:activity-compose:" + Versions.activity_compose
    val compose_ui = "androidx.compose.ui:ui:" + Versions.compose
    val compose_material = "androidx.compose.material:material:" + Versions.compose_material
    val compose_material_icons =
        "androidx.compose.material:material-icons-extended:" + Versions.compose_material
    val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:" + Versions.compose
    val core_ktx = "androidx.core:core-ktx:" + Versions.kts_core
}

object Navigation {
    val navigation_compose = "androidx.navigation:navigation-compose:" + Versions.navigation
}

object Mockito {
    val mockito = "org.mockito.kotlin:mockito-kotlin:" + Versions.mockito
}

object Lifecycle {
    val runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:" + Versions.lifecycle
    val viewmodel_compose = "androidx.lifecycle:lifecycle-viewmodel-compose:" + Versions.lifecycle
    val viewmodel_kts = "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.lifecycle
}

object Core {
    val core_ktx = "androidx.core:core-ktx:" + Versions.kts_core
}

object Firebase {
    val bom = "com.google.firebase:firebase-bom:" + Versions.firebase_bom
    val auth_ktx = "com.google.firebase:firebase-auth-ktx:" + Versions.firebase_auth
    val auth = "com.google.firebase:firebase-auth:" + Versions.firebase_auth
    val firestore = "com.google.firebase:firebase-firestore-ktx:" + Versions.firestore
}

object DaggerHilt {
    val hilt_android = "com.google.dagger:hilt-android:" + Versions.hilt
    val hilt_navigation = "androidx.hilt:hilt-navigation-compose:" + Versions.hilt_navigation
    val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:" + Versions.hilt
    val hilt_compiler = "androidx.hilt:hilt-compiler:" + Versions.hilt_compiler
}

object Coroutines {
    val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:" + Versions.coroutines
    val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:" + Versions.coroutines
}

object DataStore {
    val core = "androidx.datastore:datastore-core:" + Versions.datastore
    val preferences = "androidx.datastore:datastore-preferences:" + Versions.datastore
}

object OneSignal {
    val one_signal = "com.onesignal:OneSignal:" + Versions.one_signal
}
