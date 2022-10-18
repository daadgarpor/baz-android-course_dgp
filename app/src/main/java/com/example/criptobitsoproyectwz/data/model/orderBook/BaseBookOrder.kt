package com.example.criptobitsoproyectwz.data.model.orderBook

import com.google.gson.annotations.SerializedName

data class BaseBookOrder(
    @SerializedName("success") val exitoso: Boolean,
    @SerializedName("payload") val payload: PayloadBookOrder
)
