package com.example.criptobitsoproyectwz.domain.usesCase

import com.example.criptobitsoproyectwz.data.repository.CriptoRepository
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin
import javax.inject.Inject

class UseCaseGetDataCoin @Inject constructor(private val repository: CriptoRepository) {

    suspend operator fun invoke(): CriptoCoin? {
        val data = repository.getCriptoCoinFromDatabase()
        if (!data.book.isNullOrEmpty()) {
            return data
        }
        return null
    }

}