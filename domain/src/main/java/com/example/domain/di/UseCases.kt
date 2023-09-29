package com.example.domain.di

import com.example.data.auth.LoginRepository
import com.example.domain.usecases.LoginAuthUseCase
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
        loginRepository: LoginRepository
    ): UseCases {
        return UseCases(
            loginAuthUseCase = LoginAuthUseCase(loginRepository = loginRepository)
        )
    }
}
