package com.example.criptobitsoproyectwz.data.Repository
import com.example.criptobitsoproyectwz.data.Room.CriptoEntity
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin
import com.example.criptobitsoproyectwz.domain.wrapper.InfoCriptoCoin

interface CriptoRepository  {

    suspend fun getAllCriptos(): List<Cripto>

    suspend fun getCripto(cripto: String): CriptoCoin

    suspend fun getInfoCripto(cripto: String): InfoCriptoCoin

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