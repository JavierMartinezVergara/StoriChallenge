package com.javiermtz.storitest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.javiermtz.storitest.presentation.login.LoginScreen
import com.javiermtz.storitest.presentation.navigation.Screen.Login

@Composable
fun SetupNavigationGraph() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Login.route) {
        composable(route = Login.route) {
            LoginScreen(navHostController)
        }
    }
}
