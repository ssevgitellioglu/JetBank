package com.example.jetbank.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetbank.data.model.BankDataItem
import com.example.jetbank.domain.usecase.GetBankDataUseCase
import com.example.jetbank.util.Resources
import com.example.jetbank.view.home.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class BankViewModel @Inject constructor(private val useCase: GetBankDataUseCase) : ViewModel() {
    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    private val _filteredList = mutableStateOf<List<BankDataItem>>(emptyList())
    val filteredList: State<List<BankDataItem>> = _filteredList

    init {
        getBankList()
    }

    private fun getBankList() = viewModelScope.launch {
        useCase.invoke().collect() {
            when (it) {
                is Resources.Success -> {
                    delay(1000)
                    _state.value = HomeScreenState(isLoading = false, bankData = it.data)
                    _filteredList.value = it.data ?: emptyList()

                }

                is Resources.Error -> {
                    _state.value =
                        HomeScreenState(isLoading = false, errorMessage = it.message ?: "Error!")

                }

                is Resources.Loading -> {
                    _state.value = HomeScreenState(isLoading = true)

                }
            }
        }
    }

    fun filterList(query: String) {
        _filteredList.value = _state.value.bankData?.filter {
            (it.bankDistrict?.contains(query, ignoreCase = true) == true || (it.bankCity?.contains(
                query,
                ignoreCase = true
            ) == true))

        } ?: emptyList()
    }
}