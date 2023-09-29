package com.javiermtz.storitest.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.javiermtz.storitest.R
import com.javiermtz.storitest.ui.theme.Gray
import com.javiermtz.storitest.ui.theme.Transparent
import com.javiermtz.storitest.ui.theme.WhiteColor

@Composable
fun ButtonApp(modifier: Modifier = Modifier, text: String, isEnabled: Boolean, action: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = action,
        enabled = isEnabled,
        shape = RoundedCornerShape(24.dp),
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
        )
    }
}

@Composable
fun SignInButton(modifier: Modifier = Modifier, action: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = action,
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.dp, color = Gray),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Transparent,
        ),
    ) {
        Text(
            text = stringResource(id = R.string.sign_in),
            fontSize = 24.sp,
            color = WhiteColor,
        )
    }
}
