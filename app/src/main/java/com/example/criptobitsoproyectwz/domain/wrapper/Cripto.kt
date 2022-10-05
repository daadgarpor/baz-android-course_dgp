package com.example.criptobitsoproyectwz.domain.wrapper

import com.example.criptobitsoproyectwz.data.model.criptos.Payload
import com.example.criptobitsoproyectwz.data.room.CriptoEntity

data class Cripto(val name: String, val maximum_price: Double)

fun Payload.toDomain() = Cripto(book, maximo)
fun CriptoEntity.toDomain() = Cripto(name, maximo)
