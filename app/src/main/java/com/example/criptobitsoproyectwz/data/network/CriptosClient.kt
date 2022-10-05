package com.example.criptobitsoproyectwz.data.network

import com.example.criptobitsoproyectwz.data.dataSource.criptoDataSource
import com.example.criptobitsoproyectwz.data.model.criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.orderBook.BaseBookOrder
import com.example.criptobitsoproyectwz.data.model.ticket.TicketResult
import javax.inject.Inject

class CriptosClient @Inject constructor(private val criptoService: BitsoService) : criptoDataSource {

    override suspend fun getAllCriptos(): BaseResult = criptoService.getCriptos()

    override suspend fun getCripto(cripto: String): TicketResult = criptoService.getTicketInformation(cripto)

    override suspend fun getInfoCripto(cripto: String): BaseBookOrder = criptoService.getBookOrder(cripto)
}
