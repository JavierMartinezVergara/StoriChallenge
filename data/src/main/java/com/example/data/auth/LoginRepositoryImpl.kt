package com.example.data.auth

import com.example.authentication.AuthenticationService
import com.example.authentication.model.ResourceAuth
import com.example.authentication.model.UserInfo
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val authenticationService: AuthenticationService
) : LoginRepository {
    override suspend fun login(user: String, password: String): ResourceAuth<UserInfo> {
        return authenticationService.login(user, password)
    }

    override suspend fun createUser(email: String, password: String): ResourceAuth<String> {
        return authenticationService.registerUser(email, password)
    }
}
