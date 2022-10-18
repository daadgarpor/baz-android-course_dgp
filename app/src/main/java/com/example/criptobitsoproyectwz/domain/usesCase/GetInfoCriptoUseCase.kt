package com.example.criptobitsoproyectwz.domain.usesCase

import com.example.criptobitsoproyectwz.data.repository.CriptoRepository
import com.example.criptobitsoproyectwz.domain.wrapper.AsksCoin
import com.example.criptobitsoproyectwz.domain.wrapper.InfoCriptoCoin
import javax.inject.Inject

class GetInfoCriptoUseCase @Inject constructor(private val repository: CriptoRepository) {

    suspend operator fun invoke(cripto: String): InfoCriptoCoin = repository.getInfoCripto(cripto)

}
