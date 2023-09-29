package com.example.data.di

import com.example.data.auth.LoginRepository
import com.example.data.auth.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindsModule {

    @Binds
    @Singleton
    abstract fun bindsRepositoryLogin(loginRepository: LoginRepositoryImpl): LoginRepository
}
