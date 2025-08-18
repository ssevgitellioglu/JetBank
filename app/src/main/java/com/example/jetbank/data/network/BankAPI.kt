package com.example.jetbank.data.network

import com.example.jetbank.data.model.BankData
import retrofit2.http.GET

interface BankAPI {
    @GET("bankdata")
    suspend fun getBankDataNetwork(): BankData
}