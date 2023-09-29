package com.javiermtz.storitest.presentation.login

import com.javiermtz.storitest.presentation.model.UserData

sealed class StatesLogin {

    object Loading : StatesLogin()
    object Empty : StatesLogin()
    data class Success(val userData: UserData) : StatesLogin()
    data class Error(val message: String) : StatesLogin()
}
