package com.example.criptobitsoproyectwz.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin

@Entity(tableName = "criptoCoin_entity")
data class CriptoCoinEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "book") val book : String,
    @ColumnInfo(name = "high") val high : Double,
    @ColumnInfo(name = "low") val low : Double,
    @ColumnInfo(name = "last") val last :Double,
)

fun CriptoCoin.toDatabase() = CriptoCoinEntity(
    book = book,
    high = high,
    low = low,
    last = last
)
