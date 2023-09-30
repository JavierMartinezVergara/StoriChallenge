package com.example.firestore

import com.example.firestore.models.ResourceFireStore
import com.example.firestore.models.UserDto

interface FireStoreDb {

    suspend fun createUser(uuid: String, user: UserDto): ResourceFireStore<String>
}
