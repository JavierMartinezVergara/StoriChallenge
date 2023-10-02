package com.example.domain.usecases

data class UseCases(

    val loginAuthUseCase: LoginAuthUseCase,
    val registerUserUseCase: RegisterUserUseCase,
    val createUserUseCase: CreateUserUseCase,
    val profileGetDataUseCase: ProfileGetDataUseCase
)
