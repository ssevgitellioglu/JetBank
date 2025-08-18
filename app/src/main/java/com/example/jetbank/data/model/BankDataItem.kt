package com.example.jetbank.data.model

import com.google.gson.annotations.SerializedName

data class BankDataItem(
    @SerializedName("ID")
    val bankId: Int?=null,
    @SerializedName("dc_ADRES")
    val bankAddress: String?,
    @SerializedName("dc_ADRES_ADI")
    val bankAddressName: String?,
    @SerializedName("dc_BANKA_SUBE")
    val bankBranch: String?,
    @SerializedName("dc_BANKA_TIPI")
    val bankType: String?,
    @SerializedName("dc_BANK_KODU")
    val bankCode: String?,
    @SerializedName("dc_BOLGE_KOORDINATORLUGU")
    val bankCoordinate: String?,
    @SerializedName("dc_EN_YAKIM_ATM")
    val bankAtm: String?,
    @SerializedName("dc_ILCE")
    val bankDistrict: String?,
    @SerializedName("dc_ON_OFF_LINE")
    val bankOffline: String?,
    @SerializedName("dc_ON_OFF_SITE")
    val bankOffSite: String?,
    @SerializedName("dc_POSTA_KODU")
    val bankPostalCode: String?,
    @SerializedName("dc_SEHIR")
    val bankCity: String?
)