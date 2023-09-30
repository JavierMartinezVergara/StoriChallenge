package com.example.domain.usecases

import com.example.authentication.model.ResourceAuth.Failure
import com.example.authentication.model.ResourceAuth.Success
import com.example.data.auth.LoginRepository
import com.example.domain.models.ResponseStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(email: String, password: String): Flow<ResponseStatus<String>> {
        return flow {
            when (val resource = loginRepository.createUser(email, password)) {
                is Failure -> emit(ResponseStatus.Error(resource.exception.message.toString()))
                is Success -> emit(ResponseStatus.Success(resource.result))
            }
        }
    }
}
