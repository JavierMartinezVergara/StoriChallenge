package com.javiermtz.storitest.presentation.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javiermtz.storitest.R
import com.javiermtz.storitest.R.string
import com.javiermtz.storitest.presentation.components.ButtonApp
import com.javiermtz.storitest.presentation.components.ConfirmationMessageWithOneAction
import com.javiermtz.storitest.presentation.components.Loader
import com.javiermtz.storitest.presentation.components.TextField
import com.javiermtz.storitest.presentation.components.TextFieldComponent
import com.javiermtz.storitest.presentation.components.TextFieldType
import com.javiermtz.storitest.presentation.components.TextFieldType.Email
import com.javiermtz.storitest.presentation.components.TextFieldType.Password
import com.javiermtz.storitest.presentation.components.TextFieldType.Phone
import com.javiermtz.storitest.presentation.navigation.Screen.Home
import com.javiermtz.storitest.presentation.registration.RegisterUserState.Empty
import com.javiermtz.storitest.presentation.registration.RegisterUserState.Loading
import com.javiermtz.storitest.presentation.registration.RegisterUserState.NoCreateUser
import com.javiermtz.storitest.presentation.registration.RegisterUserState.NoRegisterUser
import com.javiermtz.storitest.presentation.registration.RegisterUserState.Success
import com.javiermtz.storitest.ui.theme.RobotoBold

@Composable
fun RegisterUserScreen(
    navController: NavHostController
) {
    Surface() {
        Column(modifier = Modifier.background(Color.Black)) {
            HeaderRegisterScreen()
            BodyRegisterScreen(navController = navController)
        }
    }
}

@Composable
fun HeaderRegisterScreen() {
    Image(
        painter = painterResource(id = R.drawable.common_full_open_on_phone),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.1f),
        contentDescription = ""
    )
}

@Composable
fun BodyRegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: RegisterUserViewModel = hiltViewModel()
) {
    when (val data = viewModel.state.value) {
        Empty -> ContentRegister(viewModel)
        is NoCreateUser -> ConfirmationMessageWithOneAction(message = stringResource(id = string.error_create_user)) {
            navController.popBackStack()
        }

        is NoRegisterUser -> ConfirmationMessageWithOneAction(message = stringResource(id = string.error_register_user)) {
            navController.popBackStack()
        }
        Loading -> Loader()
        is Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(Home.passUuid(data.data))
            }
        }
    }
//
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ContentRegister(viewModel: RegisterUserViewModel = hiltViewModel()) {
    val keyboard = LocalSoftwareKeyboardController.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .clip(RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))
            .background(MaterialTheme.colors.background)
            .fillMaxHeight(1f)
            .verticalScroll(rememberScrollState())
            .padding(vertical = 24.dp, horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.please_sign_up),
            fontFamily = RobotoBold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        val textFieldName = TextField(
            title = stringResource(id = string.name),
            type = TextFieldType.Text,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                autoCorrect = false,
                imeAction = ImeAction.Next
            )
        )
        val errorName = stringResource(id = string.error_name)
        TextFieldComponent(
            textFieldOptions = textFieldName,
            valueText = {
                viewModel.setName(it)
                viewModel.validateName(errorName)
            },
            messageError = {
                viewModel.nameErrMsg.value
            }
        )
        val textFieldLastName = TextField(
            title = stringResource(id = string.lastName),
            type = TextFieldType.Text,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                autoCorrect = false,
                imeAction = ImeAction.Next
            )
        )
        val errorLastName = stringResource(id = string.error_lastName)
        TextFieldComponent(
            textFieldOptions = textFieldLastName,
            valueText = {
                viewModel.setLastname(it)
                viewModel.validateLastName(errorLastName)
            },
            messageError = {
                viewModel.lastNameErrMsg.value
            }
        )
        val textFieldEmail = TextField(
            title = stringResource(id = string.email),
            type = Email,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                imeAction = ImeAction.Next
            )
        )
        val errorEmail = stringResource(id = string.message_error_user)
        TextFieldComponent(
            textFieldOptions = textFieldEmail,
            valueText = {
                viewModel.setEmail(it)
                viewModel.validateEmail(errorEmail)
            },
            messageError = {
                viewModel.emailErrMsg.value
            }
        )
        val textFieldPhone = TextField(
            title = stringResource(id = string.phone),
            type = Phone,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                imeAction = ImeAction.Next
            )
        )
        val errorPhone = stringResource(id = string.error_phone)
        TextFieldComponent(
            textFieldOptions = textFieldPhone,
            valueText = {
                viewModel.setPhone(it)
                viewModel.validatePhone(errorPhone)
            },
            messageError = {
                viewModel.phoneErrMsg.value
            }
        )
        val textFieldAge = TextField(
            title = stringResource(id = string.age),
            type = Phone,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                imeAction = ImeAction.Next
            )
        )
        val errorAge = stringResource(id = string.error_age)
        TextFieldComponent(
            textFieldOptions = textFieldAge,
            valueText = {
                viewModel.setAge(it)
                viewModel.validateAge(errorAge)
            },
            messageError = {
                viewModel.ageErrMsg.value
            }
        )
        val textFieldPassword = TextField(
            title = stringResource(id = string.password),
            type = Password,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { keyboard?.hide() }
            )
        )
        val errorPassword = stringResource(id = string.message_error_password)
        TextFieldComponent(
            textFieldOptions = textFieldPassword,
            valueText = {
                viewModel.setPassword(it)
                viewModel.validatePassword(errorPassword)
            },
            messageError = {
                viewModel.passwordErrMsg.value
            }
        )
        ButtonApp(
            modifier = Modifier.padding(top = 20.dp),
            text = stringResource(id = string.sign_up),
            isEnabled = viewModel.isEnabledRegisterButton.value
        ) {
            viewModel.registerUser()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterUserScreenPreview() {
    RegisterUserScreen(rememberNavController())
}
