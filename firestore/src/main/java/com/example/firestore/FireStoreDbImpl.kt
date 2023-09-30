package com.example.firestore

import com.example.firestore.models.ResourceFireStore
import com.example.firestore.models.UserDto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FireStoreDbImpl @Inject constructor(
    private val firebaseDb: FirebaseFirestore
) : FireStoreDb {
    override suspend fun createUser(uuid: String, user: UserDto): ResourceFireStore<String> {
        return try {
            firebaseDb.collection("User")
                .document(uuid)
                .set(user)
                .await()
            ResourceFireStore.Success("Success")
        } catch (e: Exception) {
            ResourceFireStore.Failure(Exception(e.message))
        }
    }
}
