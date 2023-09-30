package com.javiermtz.storitest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.javiermtz.storitest.presentation.components.PutAnExtra
import com.javiermtz.storitest.presentation.login.LoginScreen
import com.javiermtz.storitest.presentation.navigation.Screen.Home
import com.javiermtz.storitest.presentation.navigation.Screen.Login
import com.javiermtz.storitest.presentation.navigation.Screen.RegisterUser
import com.javiermtz.storitest.presentation.navigation.Screen.Splash
import com.javiermtz.storitest.presentation.registration.RegisterUserScreen
import com.javiermtz.storitest.presentation.splash.SplashScreen
import com.javiermtz.storitest.presentation.utils.Contants.UUID

@Composable
fun SetupNavigationGraph() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Splash.route) {
        composable(route = Splash.route) {
            SplashScreen(navHostController)
        }
        composable(route = Login.route) {
            LoginScreen(navHostController)
        }
        composable(
            route = Home.route,
            arguments = listOf(
                navArgument(UUID) {
                    type = NavType.StringType
                }
            )
        ) { navBackstackEntry ->
            val uuid = navBackstackEntry.arguments?.getString(UUID) ?: ""
            PutAnExtra(key = UUID, value = uuid)
        }
        composable(
            route = RegisterUser.route
        ) {
            RegisterUserScreen(navController = navHostController)
        }
    }
}
