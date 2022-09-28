package com.example.criptobitsoproyectwz.data.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CriptoDao {

    @Query("SELECT * FROM cripto_entity")
    fun getAllCriptos(): List<CriptoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCripto(entity: List<CriptoEntity>)

}