package com.example.criptobitsoproyectwz.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.criptobitsoproyectwz.domain.wrapper.AsksCoin
import com.google.gson.annotations.SerializedName

@Entity(tableName = "asksCoin_entity")
data class AskEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "book") val book: String,
    @ColumnInfo(name = "price")  val price: Double,
    @ColumnInfo(name = "amount")  val amount: Double
)

fun AsksCoin.toDatabase() = AskEntity(
    book = book,
    price = price,
    amount = amount
)

