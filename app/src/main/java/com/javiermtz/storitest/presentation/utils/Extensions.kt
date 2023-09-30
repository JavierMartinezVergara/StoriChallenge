package com.javiermtz.storitest.presentation.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavController.getDestinationRoute(): String {
    val navBackStackEntry by this.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route ?: ""
}

fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    else -> null
}

fun String.removeFirstAndLastChar(): String {
    return this.substring(1, this.length - 1)
}
