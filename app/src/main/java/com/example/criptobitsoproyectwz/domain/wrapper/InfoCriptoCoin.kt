package com.example.criptobitsoproyectwz.domain.wrapper

import com.example.criptobitsoproyectwz.data.model.orderBook.Asks
import com.example.criptobitsoproyectwz.data.model.orderBook.Bids
import com.example.criptobitsoproyectwz.data.model.orderBook.PayloadBookOrder

data class InfoCriptoCoin(
    val bids: List<Bids>,
    val asks: List<Asks>
)

fun PayloadBookOrder.toDomain() = InfoCriptoCoin(bids, asks)
