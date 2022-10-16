package com.example.criptobitsoproyectwz.domain.usesCase


import com.example.criptobitsoproyectwz.data.repository.CriptoRepository
import com.example.criptobitsoproyectwz.domain.wrapper.AsksCoin
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import javax.inject.Inject

class AskDatabaseUseCase @Inject constructor(private val repository: CriptoRepository) {

  /*  suspend operator fun invoke(): List<AsksCoin>? {
        val asks = repository.getInfoCriptoCoin()
        if (!asks.isNullOrEmpty()) {
            return asks
        }
        return null
    }*/
}