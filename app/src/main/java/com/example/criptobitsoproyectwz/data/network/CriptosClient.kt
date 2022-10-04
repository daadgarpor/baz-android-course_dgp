package com.example.criptobitsoproyectwz.data.network

import com.example.criptobitsoproyectwz.data.DataSource.criptoDataSource
import com.example.criptobitsoproyectwz.data.model.Criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.OrderBook.BaseBookOrder
import com.example.criptobitsoproyectwz.data.model.Ticket.TicketResult
import javax.inject.Inject

class CriptosClient @Inject constructor(private val criptoService: BitsoService): criptoDataSource{

    override suspend fun getAllCriptos(): BaseResult = criptoService.getCriptos()

    override suspend fun getCripto(cripto: String): TicketResult  =  criptoService.getTicketInformation(cripto)

    override suspend fun getInfoCripto(cripto: String): BaseBookOrder = criptoService.getBookOrder(cripto)


}