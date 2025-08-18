package com.example.jetbank.data.repository

import com.example.jetbank.data.model.BankData
import com.example.jetbank.data.repository.datasource.RemoteDataSource
import com.example.jetbank.domain.repository.BankRepository
import com.example.jetbank.util.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BankRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    BankRepository {
    override fun getBankDataRepository(): Flow<Resources<BankData>> = flow {
        emit(Resources.Loading())
        val result=runCatching {
            remoteDataSource.getBankDataSource()
        }.onFailure {
            emit(Resources.Error(message = it.message ?: "Error!"))
        }.getOrNull()

        result?.let {
            emit(Resources.Success(it))
        }
    }

}