package com.javiermtz.storitest.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javiermtz.storitest.R
import com.javiermtz.storitest.presentation.components.BackPressHandler
import com.javiermtz.storitest.presentation.components.ButtonApp
import com.javiermtz.storitest.presentation.components.SignInButton
import com.javiermtz.storitest.presentation.navigation.Screen
import com.javiermtz.storitest.presentation.navigation.Screen.Login
import com.javiermtz.storitest.presentation.utils.findActivity
import com.javiermtz.storitest.ui.theme.Gray
import com.javiermtz.storitest.ui.theme.RobotoBold
import com.javiermtz.storitest.ui.theme.RobotoLight
import com.javiermtz.storitest.ui.theme.WhiteColor

@Composable
fun SplashScreen(navController: NavHostController) {
    Splash(navController = navController)
}

@Composable
fun Splash(
    navController: NavHostController
) {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current

    BackPressHandler(onBackPressed = { context.findActivity()?.finish() })
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.common_full_open_on_phone),
            contentDescription = null
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(.5f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontSize = 50.sp,
                    color = WhiteColor,
                    fontFamily = RobotoBold
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight(.9f)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 50.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ButtonApp(
                        modifier = Modifier.fillMaxWidth().semantics { testTag = "login-button" },
                        text = stringResource(id = R.string.login),
                        isEnabled = true
                    ) {
                        navController.navigate(Login.route)
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(3.dp)
                            .background(Gray)
                    )
                    Text(
                        text = stringResource(id = R.string.have_an_account),
                        fontSize = 16.sp,
                        color = WhiteColor,
                        fontFamily = RobotoLight
                    )
                    SignInButton(modifier = Modifier.fillMaxWidth()) {
                        navController.navigate(Screen.RegisterUser.route)
                    }
                }
            }
            Text(
                text = stringResource(id = R.string.powered_by),
                fontSize = 16.sp,
                fontFamily = RobotoLight,
                color = WhiteColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SplashPreview() {
    Splash(rememberNavController())
}
