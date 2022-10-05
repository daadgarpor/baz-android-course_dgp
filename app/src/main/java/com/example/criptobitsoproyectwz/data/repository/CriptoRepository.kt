package com.example.criptobitsoproyectwz.data.repository
import com.example.criptobitsoproyectwz.data.room.CriptoEntity
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin
import com.example.criptobitsoproyectwz.domain.wrapper.InfoCriptoCoin

interface CriptoRepository {

    suspend fun getAllCriptos(): List<Cripto>

    suspend fun getCripto(cripto: String): CriptoCoin

    suspend fun getInfoCripto(cripto: String): InfoCriptoCoin

    suspend fun getAllCriptoFromDatabase(): List<Cripto>

    suspend fun insertAllCriptos(criptoEntity: List<CriptoEntity>)

    suspend fun deleteCriptos()
}
