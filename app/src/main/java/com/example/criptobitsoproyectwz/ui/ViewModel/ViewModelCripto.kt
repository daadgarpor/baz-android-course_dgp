package com.example.criptobitsoproyectwz.ui.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.criptobitsoproyectwz.core.CriptoResult
import com.example.criptobitsoproyectwz.data.Repository.useCaseCripto
import com.example.criptobitsoproyectwz.data.model.Criptos.BaseResult
import com.example.criptobitsoproyectwz.data.model.Criptos.Payload
import com.example.criptobitsoproyectwz.domain.Cripto
import com.example.criptobitsoproyectwz.domain.usesCase.useCaseCriptoDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelCripto @Inject constructor (
    private val getCriptoUseCase: useCaseCripto,
    private val getCriptoFromDatabaseUseCase: useCaseCriptoDatabase
    ) : ViewModel() {

    private val _dataCripto = MutableLiveData<List<Cripto>>()
    val dataCripto: LiveData<List<Cripto>>  = _dataCripto

    private val _criptos: MutableStateFlow<List<Cripto>> = MutableStateFlow(emptyList())
    val criptos: StateFlow<List<Cripto>> = _criptos.asStateFlow()


    fun getCriptos(){
        viewModelScope.launch {
            val result = getCriptoUseCase()
           _criptos.update {
               result
           }
        }
    }

    fun getCriptosFromDatabase(){
        viewModelScope.launch {
            val result = getCriptoFromDatabaseUseCase()
            if (result.isNullOrEmpty()){
                _dataCripto.postValue(result!!)
            }
        }
    }
}