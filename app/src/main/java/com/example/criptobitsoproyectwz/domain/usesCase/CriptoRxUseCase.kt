package com.example.criptobitsoproyectwz.domain.usesCase

import com.example.criptobitsoproyectwz.data.repository.CriptoRepository
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CriptoRxUseCase @Inject constructor(private val repository: CriptoRepository) {

    operator fun invoke(): Single<List<Cripto>>{
        val criptos = repository.getCriptosRx()
        return criptos.map { cripto -> cripto.filter { it.name.contains("mxn") } }
    }
}