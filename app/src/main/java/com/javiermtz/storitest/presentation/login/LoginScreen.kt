package com.javiermtz.storitest.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Email
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import com.javiermtz.storitest.R
import com.javiermtz.storitest.presentation.components.ButtonApp
import com.javiermtz.storitest.presentation.components.CheckboxLogin
import com.javiermtz.storitest.presentation.components.ConfirmationMessage
import com.javiermtz.storitest.presentation.components.TextField
import com.javiermtz.storitest.presentation.components.TextFieldComponent
import com.javiermtz.storitest.presentation.components.TextFieldType
import com.javiermtz.storitest.presentation.components.TextFieldType.Email
import com.javiermtz.storitest.presentation.components.TextFieldType.Password
import com.javiermtz.storitest.presentation.login.StatesLogin.Empty
import com.javiermtz.storitest.presentation.login.StatesLogin.Loading
import com.javiermtz.storitest.presentation.login.StatesLogin.Success
import com.javiermtz.storitest.presentation.navigation.Screen.Home
import com.javiermtz.storitest.ui.theme.Gray
import com.javiermtz.storitest.ui.theme.RobotoBold
import com.javiermtz.storitest.ui.theme.WhiteColor

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var showDialogMessage by remember {
        mutableStateOf(false)
    }
    var errorMessage by remember {
        mutableStateOf("")
    }

    if (showDialogMessage) {
        ConfirmationMessage(errorMessage)
    }

    val lifecycle = LocalLifecycleOwner.current
    val stateLogin = remember(viewModel.loginStateFlow, lifecycle) {
        viewModel.loginStateFlow.flowWithLifecycle(lifecycle.lifecycle, Lifecycle.State.STARTED)
    }.collectAsState(initial = Empty)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Gray)

    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.common_full_open_on_phone),
            contentDescription = stringResource(id = R.string.app_name)
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.3f),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LoginAppHeader()
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LoginHeader()
                        val textFieldUser = TextField(
                            title = stringResource(id = R.string.email),
                            type = TextFieldType.Email,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email,
                                capitalization = KeyboardCapitalization.None,
                                autoCorrect = false,
                                imeAction = ImeAction.Next
                            )
                        )
                        val errorUser = stringResource(id = R.string.message_error_user)
                        TextFieldComponent(
                            textFieldOptions = textFieldUser,
                            modifier = Modifier.semantics { testTag = "email-text-field" },
                            {
                                viewModel.email.value = it
                                viewModel.validateEmail(errorUser)
                            },
                            {
                                viewModel.emailErrMsg.value
                            }
                        )
                        val textFieldPassword = TextField(
                            title = stringResource(id = R.string.password),
                            type = Password,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                capitalization = KeyboardCapitalization.None,
                                autoCorrect = false,
                                imeAction = ImeAction.Done
                            ),
                            visualTransformation = PasswordVisualTransformation()
                        )
                        val errorPassword = stringResource(id = R.string.message_error_password)
                        TextFieldComponent(
                            textFieldOptions = textFieldPassword,
                            modifier = Modifier.semantics {
                                testTag = "password-text-field"
                            },
                            {
                                viewModel.password.value = it
                                viewModel.validatePassword(errorPassword)
                            },
                            {
                                viewModel.passwordErrMsg.value
                            }
                        )
                        CheckboxLogin({
                            viewModel.isChecked.value = it
                        }, {
                            viewModel.isChecked.value
                        })
                        ButtonApp(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp)
                                .semantics {
                                    testTag = "do-login-button"
                                },
                            text = stringResource(id = R.string.login),
                            isEnabled = viewModel.isEnabledRegisterButton.value
                        ) {
                            viewModel.login(
                                email = viewModel.email.value,
                                password = viewModel.password.value
                            )
                        }
                    }

                    when (val state = stateLogin.value) {
                        is StatesLogin.Error -> {
                            viewModel.setState(Empty)
                            showDialogMessage = true
                            errorMessage = state.message
                        }

                        is Loading -> {
                            CircularProgressIndicator(modifier = Modifier.padding(100.dp))
                        }

                        is Success -> {
                            LaunchedEffect(Unit) {
                                navController.navigate(Home.passUuid(state.userData.uuid))
                            }
                        }

                        else -> {
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoginHeader() {
    Text(
        text = stringResource(id = R.string.welcome_to_appointme),
        fontSize = 25.sp,
        fontFamily = RobotoBold
    )
}

@Composable
fun LoginAppHeader() {
    Text(
        text = stringResource(id = R.string.app_name),
        fontFamily = RobotoBold,
        fontSize = 40.sp,
        color = WhiteColor
    )
}
