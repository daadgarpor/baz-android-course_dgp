package com.example.criptobitsoproyectwz.data.Repository

import com.example.criptobitsoproyectwz.data.Room.toDatabase
import com.example.criptobitsoproyectwz.domain.Cripto
import com.example.criptobitsoproyectwz.domain.toDomain
import javax.inject.Inject

class useCaseCripto @Inject constructor(private val repository: CriptoRepository) {

    suspend operator fun invoke(): List<Cripto> {
        val cripto = repository.getAllCriptos()
        return if (cripto.isNotEmpty()){
            repository.deleteCriptos()
            repository.insertAllCriptos(cripto.map { it.toDatabase() } )
            cripto
        }else{
            repository.getAllCriptoFromDatabase()
        }
    }

  /*  suspend fun useCaseInfoCripto(crip: String): TicketResult? = CriptoRepository().getInfoTicker(crip)


    suspend fun useCaseAskBids(crip: String): BaseBookOrder? = CriptoRepository().getBidsAsk(crip)*/


}