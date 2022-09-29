package com.example.criptobitsoproyectwz.data.Room

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


}