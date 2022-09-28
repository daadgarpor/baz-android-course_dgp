package com.example.criptobitsoproyectwz.domain.usesCase

import com.example.criptobitsoproyectwz.data.Repository.CriptoRepository
import com.example.criptobitsoproyectwz.domain.Cripto
import javax.inject.Inject

class useCaseCriptoDatabase @Inject constructor(private val repository: CriptoRepository) {

    suspend operator fun invoke(): List<Cripto>? {
        val criptos = repository.getAllCriptoFromDatabase()
        if (!criptos.isNullOrEmpty()){
            return criptos
        }
        return null
    }

}