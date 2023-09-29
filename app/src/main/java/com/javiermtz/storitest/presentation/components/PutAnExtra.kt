
package com.javiermtz.storitest.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun PutAnExtra(
    key: String,
    value: String,
) {
    val context = LocalContext.current
}
