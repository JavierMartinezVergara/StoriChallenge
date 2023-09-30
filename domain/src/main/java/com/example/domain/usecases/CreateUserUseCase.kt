package com.example.domain.usecases

import com.example.authentication.model.ResourceAuth.Failure
import com.example.authentication.model.ResourceAuth.Success
import com.example.data.model.ResourceData
import com.example.data.user.UserRepository
import com.example.domain.mappers.toUserDto
import com.example.domain.models.ResponseStatus
import com.example.domain.models.ResponseStatus.Error
import com.example.domain.models.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(email: String, user: UserData): Flow<ResponseStatus<String>> {
        return flow {
            when (val resource = userRepository.createUser(email, user.toUserDto())) {
                is ResourceData.Failure -> emit(Error(resource.exception.message.toString()))
                is ResourceData.Success -> emit(ResponseStatus.Success(resource.result))
            }
        }
    }
}
