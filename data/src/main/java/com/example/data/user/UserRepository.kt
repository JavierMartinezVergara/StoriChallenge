package com.example.data.user

import com.example.data.model.ResourceData
import com.example.firestore.models.UserBankDto
import com.example.firestore.models.UserDto

interface UserRepository {

    suspend fun createUser(uuid: String, user: UserDto): ResourceData<String>

    suspend fun getDataUser(uuid: String): ResourceData<UserBankDto>
}
