package com.example.criptobitsoproyectwz.data.network

import com.example.criptobitsoproyectwz.data.DataSource.criptoDataSource
import com.example.criptobitsoproyectwz.data.model.Criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.Criptos.Payload
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CriptosClient @Inject constructor(private val criptoService: BitsoService): criptoDataSource{

    override suspend fun getAllCriptos(): BaseResult = criptoService.getCriptos()

}