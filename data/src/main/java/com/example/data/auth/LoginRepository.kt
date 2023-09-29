package com.example.data.auth

import com.example.authentication.model.ResourceAuth
import com.example.authentication.model.UserInfo

interface LoginRepository {

    suspend fun login(user: String, password: String): ResourceAuth<UserInfo>

    suspend fun createUser(email: String, password: String): ResourceAuth<String>
}
