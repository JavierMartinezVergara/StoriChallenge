package com.example.firestore

import com.example.firestore.models.ResourceFireStore
import com.example.firestore.models.UserBankDto
import com.example.firestore.models.UserDto

interface FireStoreDb {

    suspend fun createUser(uuid: String, user: UserDto): ResourceFireStore<String>

    suspend fun getDataUser(uuid: String): ResourceFireStore<UserBankDto>
}
