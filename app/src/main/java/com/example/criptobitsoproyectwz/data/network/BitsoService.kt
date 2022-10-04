package com.example.criptobitsoproyectwz.data.network

import com.example.criptobitsoproyectwz.data.model.Criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.OrderBook.BaseBookOrder
import com.example.criptobitsoproyectwz.data.model.Ticket.TicketResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BitsoService {

    @GET("available_books")
    suspend fun getCriptos():BaseResult

    @GET("ticker/?")
    suspend fun getTicketInformation(@Query(value = "book") cripto: String): TicketResult

    @GET("order_book/?book={cripto}")
    suspend fun getBookOrder(@Query("cripto") cripto: String): BaseBookOrder



}