package com.javiermtz.storitest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.javiermtz.storitest.R
import com.javiermtz.storitest.ui.theme.BlackColor
import com.javiermtz.storitest.ui.theme.Gray
import com.javiermtz.storitest.ui.theme.RobotoLight
import com.javiermtz.storitest.ui.theme.WhiteColor

@Composable
fun ConfirmationMessage(message: String) {
    val shouldDismiss = remember { mutableStateOf(false) }

    if (!shouldDismiss.value) {
        Dialog(
            onDismissRequest = {
                shouldDismiss.value = true
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
            ),
        ) {
            Card(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.padding(8.dp).width(360.dp).height(300.dp),
                elevation = 8.dp,
            ) {
                Column(
                    Modifier.background(color = WhiteColor),
                ) {
                    Column(modifier = Modifier.padding(top = 80.dp)) {
                        Text(
                            text = message,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 8.dp, start = 24.dp, end = 24.dp)
                                .fillMaxWidth(),
                            style = TextStyle(
                                fontFamily = RobotoLight,
                                color = BlackColor,
                                fontSize = 16.sp,
                            ),
                        )
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Button(
                            onClick = {
                                shouldDismiss.value = true
                            },
                            modifier = Modifier.height(40.dp).width(120.dp),
                            shape = RoundedCornerShape(24.dp),
                        ) {
                            Text(
                                stringResource(id = R.string.dialog_sure_action_text),
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ConfirmationMessageWithOneAction(message: String, onSureAction: () -> Unit) {
    val shouldDismiss = remember { mutableStateOf(false) }

    if (!shouldDismiss.value) {
        Dialog(
            onDismissRequest = {
                shouldDismiss.value = true
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
            ),
        ) {
            Card(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.padding(8.dp).width(360.dp).height(300.dp),
                elevation = 8.dp,
            ) {
                Column(
                    Modifier.background(color = WhiteColor),
                ) {
                    Column(modifier = Modifier.padding(top = 80.dp)) {
                        Text(
                            text = message,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 8.dp, start = 24.dp, end = 24.dp)
                                .fillMaxWidth(),
                            style = TextStyle(
                                fontFamily = RobotoLight,
                                color = BlackColor,
                                fontSize = 16.sp,
                            ),
                        )
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Button(
                            onClick = { onSureAction() },
                            modifier = Modifier.height(40.dp).width(120.dp),
                            shape = RoundedCornerShape(24.dp),
                        ) {
                            Text(
                                stringResource(id = R.string.dialog_sure_action_text),
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ConfirmationMessageWithAction(message: String, onSureAction: () -> Unit) {
    val shouldDismiss = remember { mutableStateOf(false) }

    if (!shouldDismiss.value) {
        Dialog(
            onDismissRequest = {
                shouldDismiss.value = true
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
            ),
        ) {
            Card(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.padding(8.dp).width(360.dp).height(300.dp),
                elevation = 8.dp,
            ) {
                Column(
                    Modifier.background(color = WhiteColor),
                ) {
                    Column(modifier = Modifier.padding(top = 80.dp)) {
                        Text(
                            text = message,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 8.dp, start = 24.dp, end = 24.dp)
                                .fillMaxWidth(),
                            style = TextStyle(
                                fontFamily = RobotoLight,
                                color = BlackColor,
                                fontSize = 16.sp,
                            ),
                        )
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Button(
                            onClick = { shouldDismiss.value = true },
                            modifier = Modifier.height(40.dp).width(120.dp),
                            shape = RoundedCornerShape(24.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Gray),
                        ) {
                            Text(
                                stringResource(id = R.string.dialog_close_action_text),
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
                            )
                        }
                        Button(
                            onClick = { onSureAction() },
                            modifier = Modifier.height(40.dp).width(120.dp),
                            shape = RoundedCornerShape(24.dp),
                        ) {
                            Text(
                                stringResource(id = R.string.dialog_sure_action_text),
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomAlertMessage(
    messageDialog: String,
    okButtonText: String,
    cancelButtonText: String,
    changeVisible: () -> Unit,
    okAction: () -> Unit = changeVisible,
) {
    Dialog(
        onDismissRequest = changeVisible,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
        ),
    ) {
        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.padding(8.dp).width(360.dp).height(300.dp),
            elevation = 8.dp,
        ) {
            Column(
                Modifier.background(color = WhiteColor),
            ) {
                Column(modifier = Modifier.padding(top = 80.dp)) {
                    Text(
                        text = messageDialog,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 8.dp, start = 24.dp, end = 24.dp)
                            .fillMaxWidth(),
                        style = TextStyle(
                            fontFamily = RobotoLight,
                            color = BlackColor,
                            fontSize = 16.sp,
                        ),
                    )
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    Button(
                        onClick = okAction,
                        modifier = Modifier.height(40.dp).width(120.dp),
                        shape = RoundedCornerShape(24.dp),
                    ) {
                        Text(
                            okButtonText,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
                        )
                    }
                    if (cancelButtonText.isNotEmpty()) {
                        Button(
                            onClick = changeVisible,
                            modifier = Modifier.height(40.dp).width(120.dp),
                            shape = RoundedCornerShape(24.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Gray),
                        ) {
                            Text(
                                cancelButtonText,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}
