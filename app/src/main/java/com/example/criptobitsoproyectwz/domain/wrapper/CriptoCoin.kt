package com.example.criptobitsoproyectwz.domain.wrapper

import com.example.criptobitsoproyectwz.data.model.Ticket.PayloadCripto

data class CriptoCoin(
    val book: String,
    val high: Double,
    val low: Double,
    val last: Double
)

fun PayloadCripto.toDomain() = CriptoCoin(book, high, low, last)

