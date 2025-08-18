package com.example.jetbank.di

import com.example.jetbank.data.network.BankAPI
import com.example.jetbank.data.repository.datasource.RemoteDataSource
import com.example.jetbank.data.repository.datasourceImpl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource(bankAPI: BankAPI):RemoteDataSource{
        return RemoteDataSourceImpl(bankAPI)
    }
}