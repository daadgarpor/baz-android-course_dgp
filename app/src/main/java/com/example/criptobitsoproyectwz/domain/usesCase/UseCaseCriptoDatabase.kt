package com.example.criptobitsoproyectwz.domain.usesCase

import com.example.criptobitsoproyectwz.data.repository.CriptoRepository
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import javax.inject.Inject

class UseCaseCriptoDatabase @Inject constructor(private val repository: CriptoRepository) {

    suspend operator fun invoke(): List<Cripto>? {
        val criptos = repository.getAllCriptoFromDatabase()
        if (!criptos.isNullOrEmpty()) {
            return criptos
        }
        return null
    }
}
