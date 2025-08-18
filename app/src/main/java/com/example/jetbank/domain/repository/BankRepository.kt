package com.example.jetbank.domain.repository

import com.example.jetbank.data.model.BankData
import com.example.jetbank.util.Resources
import kotlinx.coroutines.flow.Flow


interface BankRepository {
    fun getBankDataRepository(): Flow<Resources<BankData>>
}