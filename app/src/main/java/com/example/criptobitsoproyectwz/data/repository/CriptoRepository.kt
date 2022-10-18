package com.example.criptobitsoproyectwz.data.repository
import com.example.criptobitsoproyectwz.data.model.criptos.BaseResult
import com.example.criptobitsoproyectwz.data.room.CriptoCoinEntity
import com.example.criptobitsoproyectwz.data.room.CriptoEntity
import com.example.criptobitsoproyectwz.data.room.InCriptoCoinEntity
import com.example.criptobitsoproyectwz.domain.wrapper.AsksCoin
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin
import com.example.criptobitsoproyectwz.domain.wrapper.InfoCriptoCoin
import io.reactivex.rxjava3.core.Single

interface CriptoRepository {

    suspend fun getAllCriptos(): List<Cripto>

    fun getCriptosRx(): Single<List<Cripto>>

    suspend fun getCripto(cripto: String): CriptoCoin

    suspend fun getInfoCripto(cripto: String): InfoCriptoCoin


    suspend fun getAllCriptoFromDatabase(): List<Cripto>

    suspend fun insertAllCriptos(criptoEntity: List<CriptoEntity>)

    suspend fun deleteCriptos()


    suspend fun getCriptoCoinFromDatabase(): CriptoCoin

    suspend fun insertCriptoCoin(critoEntity: CriptoCoinEntity)

    suspend fun deleteCriptoCoin()


 //   suspend fun getInfoCriptoCoin(): List<AsksCoin>

/*
    suspend fun insertInfoCriptoCoin(criptoEntity: List<InCriptoCoinEntity>)

    suspend fun deleteInfoCriptoCoin()*/
}
