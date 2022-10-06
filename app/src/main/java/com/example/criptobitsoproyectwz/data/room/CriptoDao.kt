package com.example.criptobitsoproyectwz.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CriptoDao {

    @Query("SELECT * FROM cripto_entity")
    suspend fun getAllCriptos(): List<CriptoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCripto(criptoEntity: List<CriptoEntity>)

    @Query("DELETE FROM cripto_entity")
    suspend fun deleteCripto()


    @Query("SELECT * FROM criptoCoin_entity")
    suspend fun getCoinCriptos(): CriptoCoinEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoinCripto(criptoEntity: CriptoCoinEntity)

    @Query("DELETE FROM criptoCoin_entity")
    suspend fun deleteCoinCripto()

/*    @Query("SELECT * FROM inCoin_entity")
    suspend fun getInfoCriptos(): List<InCriptoCoinEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInfoCripto(criptoEntity: List<InCriptoCoinEntity>)

    @Query("DELETE FROM inCoin_entity")
    suspend fun deleteInfoCripto()*/


}
