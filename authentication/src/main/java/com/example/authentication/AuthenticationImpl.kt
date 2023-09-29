package com.example.authentication

import com.example.authentication.model.ResourceAuth
import com.example.authentication.model.UserInfo
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthenticationImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthenticationService {
    override suspend fun login(email: String, password: String): ResourceAuth<UserInfo> {
        return try {
            val auth = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val uuid = auth.user?.providerData?.first()?.uid ?: ""
            val emailUser = auth.user?.providerData?.first()?.email ?: ""
            val userInfo = UserInfo(
                uuid = uuid,
                email = emailUser
            )
            ResourceAuth.Success(userInfo)
        } catch (e: Exception) {
            ResourceAuth.Failure(Exception(e.message))
        }
    }

    override suspend fun registerUser(email: String, password: String): ResourceAuth<String> {
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val uuid = authResult.user?.uid ?: ""
            ResourceAuth.Success(uuid)
        } catch (e: Exception){
            ResourceAuth.Failure(Exception(e.message))
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }
}
