package com.example.criptobitsoproyectwz.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.criptobitsoproyectwz.data.model.orderBook.Asks
import com.example.criptobitsoproyectwz.data.model.orderBook.Bids
import com.example.criptobitsoproyectwz.domain.wrapper.InfoCriptoCoin

@Entity(tableName = "inCoin_entity")
data class InCriptoCoinEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "bids") val bids : List<Bids>,
    @ColumnInfo(name = "asks") val asks : List<Asks>,
)

fun InfoCriptoCoin.toDatabase() = InCriptoCoinEntity(
    bids =bids,
    asks = asks)
