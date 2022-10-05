package com.example.criptobitsoproyectwz.domain.usesCase

import com.example.criptobitsoproyectwz.data.repository.CriptoRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto

import org.junit.Before
import org.junit.Test

class useCaseCriptoTest {

    @RelaxedMockK
    private lateinit var criptosRepositorys: CriptoRepository


    lateinit var usecaseCripto: UseCaseCripto

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        usecaseCripto = UseCaseCripto(criptosRepositorys)
    }


    @Test
    fun `when la api return emptylist from api`() = runBlocking {
        //Given
        coEvery { criptosRepositorys.getAllCriptos() } returns emptyList()

        //When
        usecaseCripto()

        //Then
        coVerify(exactly = 1) { criptosRepositorys.getAllCriptoFromDatabase() }

    }
    @Test
    fun `when la api return emptylist from data`() = runBlocking {
        //Given
        val mylist = listOf(Cripto("dasds",12.3), Cripto("dasrds",162.3))
        coEvery { criptosRepositorys.getAllCriptos() } returns mylist

        //When
        val response = usecaseCripto()

        //Then
        coVerify(exactly = 1) { criptosRepositorys.deleteCriptos() }
        coVerify(exactly = 1) { criptosRepositorys.insertAllCriptos(any()) }
        coVerify(exactly = 0) { criptosRepositorys.getAllCriptoFromDatabase()  }
        assert(mylist == response)

    }
}