package com.example.criptobitsoproyectwz.data.model.orderBook

import com.google.gson.annotations.SerializedName

data class PayloadBookOrder(
    @SerializedName("bids") val bids: List<Bids>,
    @SerializedName("asks") val asks: List<Asks>
)
