package com.example.criptobitsoproyectwz.domain.usesCase

import com.example.criptobitsoproyectwz.data.repository.CriptoRepository
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin
import javax.inject.Inject

class UseCaseDataCripto @Inject constructor(private val repository: CriptoRepository) {

    suspend fun getDataCripto(cripto: String): CriptoCoin = repository.getCripto(cripto)
}
