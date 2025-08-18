package com.example.jetbank.di

import com.example.jetbank.data.repository.BankRepositoryImpl
import com.example.jetbank.data.repository.datasource.RemoteDataSource
import com.example.jetbank.domain.repository.BankRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesBankRepository(remoteDataSource: RemoteDataSource):BankRepository{
        return BankRepositoryImpl(remoteDataSource)
    }
}