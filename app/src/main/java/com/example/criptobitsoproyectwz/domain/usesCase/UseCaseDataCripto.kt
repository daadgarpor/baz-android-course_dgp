package com.example.criptobitsoproyectwz.domain.usesCase

import com.example.criptobitsoproyectwz.data.repository.CriptoRepository
import com.example.criptobitsoproyectwz.data.room.toDatabase
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin
import javax.inject.Inject

class UseCaseDataCripto @Inject constructor(private val repository: CriptoRepository) {

    suspend operator fun invoke (cripto: String): CriptoCoin {
        val data = repository.getCripto(cripto)

        return if (!data.book.isNullOrEmpty()) {
            repository.deleteCriptoCoin()
            repository.insertCriptoCoin(data.toDatabase())
            data
        } else {
            repository.getCriptoCoinFromDatabase()
        }
    }
}
