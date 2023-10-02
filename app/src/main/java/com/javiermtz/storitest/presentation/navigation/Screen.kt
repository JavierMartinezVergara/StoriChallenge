package com.javiermtz.storitest.presentation.navigation

import androidx.compose.ui.tooling.data.EmptyGroup.data
import com.example.domain.models.MovementData
import com.javiermtz.storitest.presentation.utils.Contants.DETAIL_SCREEN
import com.javiermtz.storitest.presentation.utils.Contants.HOME_SCREEN
import com.javiermtz.storitest.presentation.utils.Contants.LOGIN_SCREEN
import com.javiermtz.storitest.presentation.utils.Contants.REGISTER_SCREEN
import com.javiermtz.storitest.presentation.utils.Contants.SPLASH_SCREEN

sealed class Screen(val route: String) {

    object Splash : Screen(route = SPLASH_SCREEN)
    object Login : Screen(route = LOGIN_SCREEN)

    object Home : Screen(route = "$HOME_SCREEN${"{uuid}"}") {
        fun passUuid(uuid: String): String = "$HOME_SCREEN$uuid"
    }

    object Detail : Screen(route = "\"$DETAIL_SCREEN${"{data}"}\"") {
        fun passUuid(data: MovementData): String = "$DETAIL_SCREEN$data"
    }

    object RegisterUser : Screen(route = "\"$REGISTER_SCREEN${"{uuid}"}\"") {
        fun passUuid(uuid: String): String = "$REGISTER_SCREEN$uuid"
    }
}
