package com.example.jetbank.data.repository.datasourceImpl

import com.example.jetbank.data.model.BankData
import com.example.jetbank.data.network.BankAPI
import com.example.jetbank.data.repository.datasource.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val bankAPI: BankAPI):RemoteDataSource {
    override suspend fun getBankDataSource(): BankData {
        return bankAPI.getBankDataNetwork()
    }
}