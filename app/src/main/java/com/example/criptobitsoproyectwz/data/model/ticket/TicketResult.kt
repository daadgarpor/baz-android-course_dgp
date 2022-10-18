package com.example.criptobitsoproyectwz.data.model.ticket

import com.google.gson.annotations.SerializedName

data class TicketResult(
    @SerializedName("success") val success: Boolean,
    @SerializedName("payload") val payload: PayloadCripto
)
