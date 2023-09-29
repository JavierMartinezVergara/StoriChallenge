package com.example.authentication

import com.example.authentication.model.ResourceAuth
import com.example.authentication.model.UserInfo

interface AuthenticationService {

    suspend fun login(email: String, password: String): ResourceAuth<UserInfo>

    suspend fun registerUser(email: String, password: String): ResourceAuth<String>

    fun logout()
}
