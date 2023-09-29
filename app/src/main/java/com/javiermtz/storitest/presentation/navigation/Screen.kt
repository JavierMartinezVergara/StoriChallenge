package com.javiermtz.storitest.presentation.navigation

import com.javiermtz.storitest.presentation.utils.Contants.DETAIL_SCREEN
import com.javiermtz.storitest.presentation.utils.Contants.HOME_SCREEN
import com.javiermtz.storitest.presentation.utils.Contants.LOGIN_SCREEN
import com.javiermtz.storitest.presentation.utils.Contants.REGISTER_SCREEN

sealed class Screen(val route: String) {

    object Login : Screen(route = LOGIN_SCREEN)

    object Home : Screen(route = "$HOME_SCREEN${"uuid"}") {
        fun passUuid(uuid: String): String = "$HOME_SCREEN$uuid"
    }

    object Detail : Screen(route = "\"$DETAIL_SCREEN${"uuid"}\"") {
        fun passUuid(uuid: String): String = "$DETAIL_SCREEN$uuid"
    }

    object Register : Screen(route = "\"$REGISTER_SCREEN${"uuid"}\"") {
        fun passUuid(uuid: String): String = "$REGISTER_SCREEN$uuid"
    }
}
