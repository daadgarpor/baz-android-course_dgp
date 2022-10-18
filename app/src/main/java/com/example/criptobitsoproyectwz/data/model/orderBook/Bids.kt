package com.example.criptobitsoproyectwz.data.model.orderBook

import com.google.gson.annotations.SerializedName

data class Bids(
    @SerializedName("book") val book: String,
    @SerializedName("price") val price: Double,
    @SerializedName("amount") val amount: Double
)
