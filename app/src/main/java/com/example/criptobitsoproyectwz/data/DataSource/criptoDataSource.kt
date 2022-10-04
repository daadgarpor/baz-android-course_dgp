package com.example.criptobitsoproyectwz.data.DataSource

import com.example.criptobitsoproyectwz.data.model.Criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.OrderBook.BaseBookOrder
import com.example.criptobitsoproyectwz.data.model.Ticket.TicketResult

interface criptoDataSource {
    suspend fun getAllCriptos(): BaseResult

    suspend fun getCripto(cripto: String): TicketResult

    suspend fun getInfoCripto(cripto: String): BaseBookOrder
}