package com.example.criptobitsoproyectwz.data.DataSource

import com.example.criptobitsoproyectwz.data.model.Criptos.BaseResult

interface criptoDataSource {
    suspend fun getAllCriptos(): BaseResult
}