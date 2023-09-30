package com.example.domain.models

data class UserData(
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val mobile: String = "",
    val age: Int = 10,
    val tokenNotification: String = "",
    val userType: Int = 1,
    val urlImageProfile: String = ""
)
