package com.example.jetbank.domain.usecase

import com.example.jetbank.domain.repository.BankRepository
import javax.inject.Inject

class GetBankDataUseCase @Inject constructor(private val repository: BankRepository) {
    fun invoke()=repository.getBankDataRepository()
}