package com.example.authentication.di

import com.example.authentication.AuthenticationImpl
import com.example.authentication.AuthenticationService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthenticationBindsModule {

    @Binds
    @Singleton
    abstract fun bindsAuthService(authenticationService: AuthenticationImpl): AuthenticationService
}
