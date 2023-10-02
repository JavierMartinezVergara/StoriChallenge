package com.example.firestore

import android.util.Log
import com.example.firestore.models.MovementDto
import com.example.firestore.models.ResourceFireStore
import com.example.firestore.models.UserBankDto
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

    override suspend fun getDataUser(uuid: String): ResourceFireStore<UserBankDto> {
        return try {
            val userDataComplete = UserBankDto()
            val snapshot = firebaseDb.collection("User")
                .document(uuid)
                .get()
                .await()

            with(snapshot.toObject(UserDto::class.java)) {
                userDataComplete.copy(
                    name = this?.name ?: "Desconocido"
                )
            }

            val cards = firebaseDb.collection("User")
                .document(uuid)
                .collection("Movements")
                .get()
                .await()

            Log.d("TEST", cards.documents.toString())

            val movements = cards.documents.map {
                it?.toObject(MovementDto::class.java)
            }
            movements.map {
                it?.let {
                    userDataComplete.movements.add(
                        it
                    )
                }
            }

            Log.d("TEST", movements.toString())

            ResourceFireStore.Success(userDataComplete)
        } catch (e: Exception) {
            ResourceFireStore.Failure(Exception(e.message))
        }
    }
}
