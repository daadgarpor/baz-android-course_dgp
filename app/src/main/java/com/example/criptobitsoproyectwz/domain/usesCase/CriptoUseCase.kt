package com.example.criptobitsoproyectwz.domain.usesCase

import android.util.Log
import com.example.criptobitsoproyectwz.data.repository.CriptoRepository
import com.example.criptobitsoproyectwz.data.room.toDatabase
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import javax.inject.Inject

class CriptoUseCase @Inject constructor(private val repository: CriptoRepository) {

    suspend operator fun invoke(): List<Cripto> {
        val cripto = repository.getAllCriptos()
        return if (!cripto.isNullOrEmpty()) {
            repository.deleteCriptos()
            repository.insertAllCriptos(cripto.map { it.toDatabase() })
            cripto
        } else {
            repository.getAllCriptoFromDatabase()
        }
    }

}
