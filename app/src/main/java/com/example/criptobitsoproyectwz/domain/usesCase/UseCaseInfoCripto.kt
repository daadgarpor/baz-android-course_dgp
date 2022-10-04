package com.example.criptobitsoproyectwz.domain.usesCase

import com.example.criptobitsoproyectwz.data.Repository.CriptoRepository
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin
import com.example.criptobitsoproyectwz.domain.wrapper.InfoCriptoCoin
import javax.inject.Inject

class UseCaseInfoCripto @Inject constructor(private val repository: CriptoRepository) {

    suspend fun getDataCripto(cripto: String ): InfoCriptoCoin = repository.getInfoCripto(cripto)

}