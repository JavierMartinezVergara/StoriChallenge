package com.example.domain.usecases

import com.example.authentication.model.ResourceAuth.Failure
import com.example.authentication.model.ResourceAuth.Success
import com.example.authentication.model.UserInfo
import com.example.data.auth.LoginRepository
import com.example.domain.models.ResponseStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginAuthUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(email: String, password: String): Flow<ResponseStatus<UserInfo>> {
        return flow {
            when (val data = loginRepository.login(email, password)) {
                is Failure -> emit(ResponseStatus.Error(data.exception.message.toString()))
                is Success -> emit(ResponseStatus.Success(data.result))
            }
        }.flowOn(Dispatchers.IO)
    }
}


