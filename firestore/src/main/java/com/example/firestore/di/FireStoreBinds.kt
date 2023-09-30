package com.example.firestore.di

import com.example.firestore.FireStoreDb
import com.example.firestore.FireStoreDbImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FireStoreBinds {

    @Binds
    @Singleton
    abstract fun bindsFireStoreDb(fireStoreDbImpl: FireStoreDbImpl): FireStoreDb
}
