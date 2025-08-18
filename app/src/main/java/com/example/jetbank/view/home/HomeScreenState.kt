package com.example.jetbank.view.home

import com.example.jetbank.data.model.BankDataItem

data class HomeScreenState (
    val isLoading:Boolean=false,
    val bankData:ArrayList<BankDataItem>?=null,
    val errorMessage:String?=null,
    val selectedLanguage: String = "tr"
)