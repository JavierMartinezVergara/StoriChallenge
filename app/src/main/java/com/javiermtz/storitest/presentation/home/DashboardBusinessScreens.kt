package com.javiermtz.storitest.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.javiermtz.storitest.R.drawable

@Composable
fun HeaderDashboard() {
    Surface(
        color = Color.White
    ) {
        Box(
            modifier = with(Modifier) {
                paint(
                    painterResource(id = drawable.common_full_open_on_phone),
                    contentScale = ContentScale.Crop
                ).height(20.dp)
            }
        ) {
        }
    }
}
