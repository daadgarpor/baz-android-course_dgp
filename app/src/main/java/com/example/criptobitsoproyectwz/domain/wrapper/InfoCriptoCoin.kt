package com.example.criptobitsoproyectwz.domain.wrapper

import com.example.criptobitsoproyectwz.data.model.OrderBook.Asks
import com.example.criptobitsoproyectwz.data.model.OrderBook.Bids
import com.example.criptobitsoproyectwz.data.model.OrderBook.PayloadBookOrder


data class InfoCriptoCoin(
    val bids: List<Bids>,
    val asks: List<Asks>
)

fun PayloadBookOrder.toDomain() = InfoCriptoCoin(bids,asks)