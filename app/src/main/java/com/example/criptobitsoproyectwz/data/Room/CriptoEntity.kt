package com.example.criptobitsoproyectwz.data.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cripto_entity")
data class CriptoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "name_cripto") val name: String = "",
    @ColumnInfo(name = "maximum_price") val maximo: Double = 0.0
)
