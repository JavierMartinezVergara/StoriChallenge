package com.javiermtz.storitest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.javiermtz.storitest.presentation.components.TextFieldType.Email
import com.javiermtz.storitest.presentation.components.TextFieldType.Password
import com.javiermtz.storitest.presentation.components.TextFieldType.Phone
import com.javiermtz.storitest.presentation.components.TextFieldType.Search
import com.javiermtz.storitest.ui.theme.BlackColor
import com.javiermtz.storitest.ui.theme.PrimaryColor
import com.javiermtz.storitest.ui.theme.RobotoMedium
import com.javiermtz.storitest.ui.theme.WhiteColor

@Composable
fun TextFieldComponent(
    textFieldOptions: TextField,
    modifier: Modifier = Modifier,
    valueText: (String) -> Unit,
    messageError: () -> String
) {
    var isError by remember {
        mutableStateOf(false)
    }
    var text by remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    var errorMessage by remember {
        mutableStateOf("")
    }
    errorMessage = messageError.invoke()
    Column {
        when (textFieldOptions.type) {
            Email -> {
                OutlinedTextField(
                    modifier = modifier
                        .background(Color.White)
                        .fillMaxWidth(),
                    label = { Text(text = textFieldOptions.title, fontFamily = RobotoMedium) },
                    value = text,
                    shape = RoundedCornerShape(50.dp),
                    visualTransformation = textFieldOptions.visualTransformation,
                    keyboardOptions = textFieldOptions.keyboardOptions,
                    onValueChange = {
                        text = it
                        valueText.invoke(text)
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = BlackColor,
                        backgroundColor = WhiteColor,
                        focusedBorderColor = PrimaryColor
                    ),
                    isError = isError
                )
                if (errorMessage.isNotEmpty()) {
                    isError = true
                    Text(
                        text = errorMessage,
                        color = PrimaryColor,
                        fontFamily = RobotoMedium,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            Password -> {
                OutlinedTextField(
                    modifier = modifier
                        .background(Color.White)
                        .fillMaxWidth(),
                    label = { Text(text = textFieldOptions.title, fontFamily = RobotoMedium) },
                    value = text,
                    shape = RoundedCornerShape(50.dp),
                    visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = textFieldOptions.keyboardOptions,
                    keyboardActions = textFieldOptions.keyboardActions,
                    onValueChange = {
                        text = it
                        valueText.invoke(text)
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = BlackColor,
                        backgroundColor = WhiteColor,
                        focusedBorderColor = PrimaryColor
                    ),
                    trailingIcon = {
                        val image = if (passwordVisible.value) {
                            Filled.Visibility
                        } else {
                            Filled.VisibilityOff
                        }
                        IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                            Icon(imageVector = image, "")
                        }
                    },
                    isError = isError
                )
                if (errorMessage.isNotEmpty()) {
                    isError = true
                    Text(
                        text = errorMessage,
                        color = PrimaryColor,
                        fontFamily = RobotoMedium,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            TextFieldType.Text -> {
                OutlinedTextField(
                    modifier = modifier
                        .fillMaxWidth(),
                    label = { Text(text = textFieldOptions.title, fontFamily = RobotoMedium) },
                    value = text,
                    shape = RoundedCornerShape(50.dp),
                    visualTransformation = textFieldOptions.visualTransformation,
                    keyboardOptions = textFieldOptions.keyboardOptions,
                    onValueChange = {
                        text = it
                        valueText.invoke(text)
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = BlackColor,
                        backgroundColor = WhiteColor,
                        focusedBorderColor = PrimaryColor
                    ),
                    isError = isError
                )
                if (errorMessage.isNotEmpty()) {
                    isError = true
                    Text(
                        text = errorMessage,
                        color = PrimaryColor,
                        fontFamily = RobotoMedium,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            Search -> {
                OutlinedTextField(
                    modifier = modifier
                        .fillMaxWidth(),
                    label = { Text(text = textFieldOptions.title, fontFamily = RobotoMedium) },
                    value = text,
                    shape = RoundedCornerShape(50.dp),
                    visualTransformation = textFieldOptions.visualTransformation,
                    keyboardOptions = textFieldOptions.keyboardOptions,
                    onValueChange = {
                        text = it
                        valueText.invoke(text)
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = BlackColor,
                        backgroundColor = WhiteColor,
                        focusedBorderColor = PrimaryColor
                    ),
                    isError = isError
                )
            }

            Phone -> {
                OutlinedTextField(
                    modifier = modifier
                        .fillMaxWidth(),
                    label = { Text(text = textFieldOptions.title, fontFamily = RobotoMedium) },
                    value = text,
                    shape = RoundedCornerShape(50.dp),
                    visualTransformation = textFieldOptions.visualTransformation,
                    keyboardOptions = textFieldOptions.keyboardOptions,
                    onValueChange = {
                        text = it
                        valueText.invoke(text)
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = BlackColor,
                        backgroundColor = WhiteColor,
                        focusedBorderColor = PrimaryColor
                    ),
                    isError = isError
                )
                if (errorMessage.isNotEmpty()) {
                    isError = true
                    Text(
                        text = errorMessage,
                        color = PrimaryColor,
                        fontFamily = RobotoMedium,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}

enum class TextFieldType {
    Email,
    Password,
    Text,
    Search,
    Phone
}

data class TextField(
    val title: String,
    val type: TextFieldType,
    val keyboardOptions: KeyboardOptions,
    val keyboardActions: KeyboardActions = KeyboardActions(),
    val visualTransformation: VisualTransformation = VisualTransformation.None
)
