package com.example.criptobitsoproyectwz.domain.wrapper

import com.example.criptobitsoproyectwz.data.room.AskEntity
import com.google.gson.annotations.SerializedName

data class AsksCoin(
     val book: String,
     val price: Double,
     val amount: Double
)
fun AskEntity.toDomain() = AsksCoin(book = book,price = price, amount = amount)