package com.javiermtz.storitest.presentation.registration

sealed class RegisterUserState {
    object Loading : RegisterUserState()
    data class Success(val data: String) : RegisterUserState()
    object Empty : RegisterUserState()
    data class NoRegisterUser(val message: String) : RegisterUserState()
    data class NoCreateUser(val message: String) : RegisterUserState()
}
