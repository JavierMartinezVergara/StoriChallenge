package com.example.domain.usecases

import com.example.data.model.ResourceData
import com.example.data.user.UserRepository
import com.example.domain.mappers.toProfileData
import com.example.domain.models.ProfileData
import com.example.domain.models.ResponseStatus
import com.example.domain.models.ResponseStatus.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfileGetDataUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(uuid: String): Flow<ResponseStatus<ProfileData>> {
        return flow {
            when (val resource = userRepository.getDataUser(uuid)) {
                is ResourceData.Failure -> emit(Error(resource.exception.message.toString()))
                is ResourceData.Success -> emit(ResponseStatus.Success(resource.result.toProfileData()))
            }
        }
    }
}
