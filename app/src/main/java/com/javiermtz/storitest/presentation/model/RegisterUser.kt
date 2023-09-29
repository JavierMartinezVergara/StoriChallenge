package com.javiermtz.storitest.presentation.model

data class RegisterUser(
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = ""
)
