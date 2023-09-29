package com.javiermtz.storitest.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.javiermtz.storitest.R
import com.javiermtz.storitest.ui.theme.PrimaryColor
import com.javiermtz.storitest.ui.theme.RobotoMedium

@Composable
fun CheckboxLogin(setValue: (Boolean) -> Unit, isCheckedValue: () -> Boolean) {
    var isChecked by remember {
        mutableStateOf(false)
    }
    isChecked = isCheckedValue.invoke()
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(id = R.string.remember_me),
            fontSize = 16.sp,
            fontFamily = RobotoMedium,
        )
        Checkbox(
            colors = CheckboxDefaults.colors(PrimaryColor),
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
                setValue.invoke(isChecked)
            },
        )
    }
}
