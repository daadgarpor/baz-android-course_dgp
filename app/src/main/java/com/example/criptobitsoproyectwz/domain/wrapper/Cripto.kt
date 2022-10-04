package com.example.criptobitsoproyectwz.domain.wrapper

import com.example.criptobitsoproyectwz.data.Room.CriptoEntity
import com.example.criptobitsoproyectwz.data.model.Criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.Criptos.Payload

data class Cripto(val name: String, val maximum_price: Double)

fun Payload.toDomain() = Cripto(book, maximo)
fun CriptoEntity.toDomain() = Cripto(name, maximo)
