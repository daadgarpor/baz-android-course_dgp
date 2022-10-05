package com.example.criptobitsoproyectwz.data.dataSource

import com.example.criptobitsoproyectwz.data.model.criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.orderBook.BaseBookOrder
import com.example.criptobitsoproyectwz.data.model.ticket.TicketResult

interface criptoDataSource {
    suspend fun getAllCriptos(): BaseResult

    suspend fun getCripto(cripto: String): TicketResult

    suspend fun getInfoCripto(cripto: String): BaseBookOrder
}
