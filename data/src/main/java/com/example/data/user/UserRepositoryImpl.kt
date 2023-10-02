package com.example.data.user

import com.example.data.model.ResourceData
import com.example.firestore.FireStoreDb
import com.example.firestore.models.ResourceFireStore.Failure
import com.example.firestore.models.ResourceFireStore.Success
import com.example.firestore.models.UserBankDto
import com.example.firestore.models.UserDto
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firebaseDb: FireStoreDb
) : UserRepository {
    override suspend fun createUser(uuid: String, user: UserDto): ResourceData<String> {
        return when (val resourceUser = firebaseDb.createUser(uuid, user)) {
            is Failure -> ResourceData.Failure(resourceUser.exception)
            is Success -> ResourceData.Success(resourceUser.result)
        }
    }

    override suspend fun getDataUser(uuid: String): ResourceData<UserBankDto> {
        return when (val resourceUser = firebaseDb.getDataUser(uuid)) {
            is Failure -> ResourceData.Failure(resourceUser.exception)
            is Success -> ResourceData.Success(resourceUser.result)
        }
    }
}
