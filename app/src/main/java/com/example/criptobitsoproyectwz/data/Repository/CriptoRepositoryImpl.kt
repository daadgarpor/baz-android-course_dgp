package com.example.criptobitsoproyectwz.data.Repository

import com.example.criptobitsoproyectwz.data.DataSource.criptoDataSource
import com.example.criptobitsoproyectwz.data.Room.CriptoDao
import com.example.criptobitsoproyectwz.data.Room.CriptoEntity
import com.example.criptobitsoproyectwz.data.model.Criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.Criptos.Payload
import com.example.criptobitsoproyectwz.domain.Cripto
import com.example.criptobitsoproyectwz.domain.toDomain
import retrofit2.Response
import javax.inject.Inject

class CriptoRepositoryImpl @Inject constructor(
    private val remoteDataSource: criptoDataSource,
    private val criptoDao: CriptoDao
    ): CriptoRepository {

    override suspend fun getAllCriptos(): List<Cripto> {
        val response: BaseResult = remoteDataSource.getAllCriptos()
        return response.payload.map{ it.toDomain()}
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