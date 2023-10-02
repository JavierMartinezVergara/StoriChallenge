package com.example.domain.di

import com.example.data.auth.LoginRepository
import com.example.data.user.UserRepository
import com.example.domain.usecases.CreateUserUseCase
import com.example.domain.usecases.LoginAuthUseCase
import com.example.domain.usecases.ProfileGetDataUseCase
import com.example.domain.usecases.RegisterUserUseCase
import com.example.domain.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCases(
        loginRepository: LoginRepository,
        userRepository: UserRepository
    ): UseCases {
        return UseCases(
            loginAuthUseCase = LoginAuthUseCase(loginRepository = loginRepository),
            registerUserUseCase = RegisterUserUseCase(loginRepository = loginRepository),
            createUserUseCase = CreateUserUseCase(userRepository = userRepository),
            profileGetDataUseCase = ProfileGetDataUseCase(userRepository = userRepository)
        )
    }
}
