/*
 * ToastComposable.kt
 * AppointME App Android
 * Created by Victor Hugo Morales Mendoza (Hugeek) on 2/13/23, 4:13 PM
 * Copyright © 2023 Globant. All rights reserved.
 */

package com.javiermtz.storitest.presentation.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ToastComposable(text: String) {
    val context = LocalContext.current
    Toast.makeText(context, "Error $text", Toast.LENGTH_LONG).show()
}
