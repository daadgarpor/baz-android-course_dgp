package com.example.criptobitsoproyectwz.data.Repository


import android.util.Log
import com.example.criptobitsoproyectwz.data.Room.toDatabase
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import javax.inject.Inject

class UseCaseCripto @Inject constructor(private val repository: CriptoRepository) {

    suspend operator fun invoke(): List<Cripto> {
        val cripto = repository.getAllCriptos()

        //return if (CoreUtil.checkNetworkStatus()){
        return if (!cripto.isNullOrEmpty()){
            repository.deleteCriptos()
            repository.insertAllCriptos(cripto.map { it.toDatabase() } )
            cripto
        }else{
            Log.d("INFO", "invoke: ENTRO ALA BD")
            repository.getAllCriptoFromDatabase()
        }
    }

  /*  suspend fun useCaseInfoCripto(crip: String): TicketResult? = CriptoRepository().getInfoTicker(crip)


    suspend fun useCaseAskBids(crip: String): BaseBookOrder? = CriptoRepository().getBidsAsk(crip)*/


}