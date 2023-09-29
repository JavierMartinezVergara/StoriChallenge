/*
 * CustomDropdownMenu.kt
 * AppointME App Android
 * Created by Victor Hugo Morales Mendoza (Hugeek) on 3/10/23, 2:30 PM
 * Copyright © 2023 Globant. All rights reserved.
 */

package com.javiermtz.storitest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.javiermtz.storitest.presentation.utils.Contants.ICON_DROPDOWN
import com.javiermtz.storitest.ui.theme.RobotoLight

@Composable
fun CustomDropdownMenu(items: List<String>?, bgColor: Color, onItemSelected: (Int) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    val borderColor = Color.Red
    Row(
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 8.dp)
            .border(1.dp, borderColor, RoundedCornerShape(size = 16.dp)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = items?.get(selectedIndex) ?: "",
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
                .clickable { expanded = true },
        )
        IconButton(onClick = { expanded = true }) {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = ICON_DROPDOWN,
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(bgColor)
                .clip(shape = RoundedCornerShape(size = 16.dp))
                .padding(start = 8.dp),
        ) {
            items?.forEachIndexed { index, element ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    onItemSelected(index)
                    expanded = false
                }) {
                    Text(
                        text = element,
                        fontFamily = RobotoLight,
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
        }
    }
}
