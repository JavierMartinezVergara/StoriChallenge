package com.javiermtz.storitest.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.javiermtz.storitest.R
import com.javiermtz.storitest.presentation.components.BackPressHandler
import com.javiermtz.storitest.presentation.components.ConfirmationMessageWithOneAction
import com.javiermtz.storitest.presentation.components.Loader
import com.javiermtz.storitest.presentation.utils.findActivity

@Composable
fun HomeScreen(
    navController: NavHostController,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val profileInfo = profileViewModel.profileInfo.value

    BackPressHandler(onBackPressed = { context.findActivity()?.finish() })

    when (profileInfo) {
        is StateDashboard.Success -> {
            UserScreen(
                navController = navController,
                profileViewModel = profileViewModel,
                profileDataClient = profileInfo.data
            )
        }

        is StateDashboard.Error -> ConfirmationMessageWithOneAction(message = stringResource(id = R.string.error_has_occurred)) {
            navController.popBackStack()
        }

        else -> Loader()
    }
}
