package com.example.criptobitsoproyectwz.data.repository

import com.example.criptobitsoproyectwz.data.room.CriptoDao
import com.example.criptobitsoproyectwz.data.room.CriptoEntity
import com.example.criptobitsoproyectwz.data.dataSource.criptoDataSource
import com.example.criptobitsoproyectwz.data.model.criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.orderBook.BaseBookOrder
import com.example.criptobitsoproyectwz.data.model.ticket.TicketResult
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin
import com.example.criptobitsoproyectwz.domain.wrapper.InfoCriptoCoin
import com.example.criptobitsoproyectwz.domain.wrapper.toDomain
import javax.inject.Inject

class CriptoRepositoryImpl @Inject constructor(
    private val remoteDataSource: criptoDataSource,
    private val criptoDao: CriptoDao
) : CriptoRepository {

    override suspend fun getAllCriptos(): List<Cripto> {
        val response: BaseResult = remoteDataSource.getAllCriptos()
        return response.payload.map { it.toDomain() }
    }

    override suspend fun getCripto(cripto: String): CriptoCoin {
        val response: TicketResult = remoteDataSource.getCripto(cripto)
        return response.payload.toDomain()
    }

    override suspend fun getInfoCripto(cripto: String): InfoCriptoCoin {
        val response: BaseBookOrder = remoteDataSource.getInfoCripto(cripto)
        return response.payload.toDomain()
    }

    override suspend fun getAllCriptoFromDatabase(): List<Cripto> {
        val response: List<CriptoEntity> = criptoDao.getAllCriptos()
        return response.map { it.toDomain() }
    }

    override suspend fun insertAllCriptos(criptoEntity: List<CriptoEntity>) {
        criptoDao.insertCripto(criptoEntity)
    }

    override suspend fun deleteCriptos() {
        criptoDao.deleteCripto()
    }
}
