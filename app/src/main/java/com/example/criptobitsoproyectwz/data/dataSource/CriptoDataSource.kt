package com.example.criptobitsoproyectwz.data.dataSource

import com.example.criptobitsoproyectwz.data.model.criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.orderBook.BaseBookOrder
import com.example.criptobitsoproyectwz.data.model.ticket.TicketResult
import io.reactivex.rxjava3.core.Single

interface CriptoDataSource {

    suspend fun getAllCriptos(): BaseResult

    fun getCriptosRX(): Single<BaseResult>

    suspend fun getCripto(cripto: String): TicketResult

    suspend fun getInfoCripto(cripto: String): BaseBookOrder
}
