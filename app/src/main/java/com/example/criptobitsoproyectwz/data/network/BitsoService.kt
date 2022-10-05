package com.example.criptobitsoproyectwz.data.network

import com.example.criptobitsoproyectwz.data.model.criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.orderBook.BaseBookOrder
import com.example.criptobitsoproyectwz.data.model.ticket.TicketResult
import retrofit2.http.GET
import retrofit2.http.Query

interface BitsoService {

    @GET("available_books")
    suspend fun getCriptos(): BaseResult

    @GET("ticker/?")
    suspend fun getTicketInformation(@Query(value = "book") cripto: String): TicketResult

    @GET("order_book/?")
    suspend fun getBookOrder(@Query("book") cripto: String): BaseBookOrder
}
