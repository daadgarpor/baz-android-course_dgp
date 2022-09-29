package com.example.criptobitsoproyectwz.data.Repository


import com.example.criptobitsoproyectwz.data.DataSource.criptoDataSource
import com.example.criptobitsoproyectwz.data.Room.CriptoEntity
import com.example.criptobitsoproyectwz.data.model.Criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.Criptos.Payload
import com.example.criptobitsoproyectwz.domain.Cripto
import retrofit2.Response
import javax.inject.Inject

interface CriptoRepository  {

    suspend fun getAllCriptos(): List<Cripto>

    suspend fun getAllCriptoFromDatabase(): List<Cripto>

    suspend fun insertAllCriptos(criptoEntity: List<CriptoEntity>)

    suspend fun deleteCriptos()


 /*   suspend fun getAllCriptos(): BaseResult? {
        return withContext(Dispatchers.IO) {
            val response = Retrofit.getRetrofit().create(BitsoService::class.java)
                .getCriptos("available_books")
            response.body()
        }
    }

    suspend fun getInfoTicker(cripto: String): TicketResult? {
        return withContext(Dispatchers.IO) {
            val response = Retrofit.getRetrofit().create(BitsoService::class.java)
                .getTicketInformation("ticker/?book=$cripto")
            response.body()
        }
    }

    suspend fun getBidsAsk(cripto: String): BaseBookOrder? {
        return withContext(Dispatchers.IO) {
            val response = Retrofit.getRetrofit().create(BitsoService::class.java)
                .getBookOrder("order_book/?book=$cripto")
            response.body()
        }
    }*/

}