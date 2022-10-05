package com.example.criptobitsoproyectwz.ui.viewModel

import androidx.lifecycle.*
import com.example.criptobitsoproyectwz.domain.usesCase.UseCaseCripto
import com.example.criptobitsoproyectwz.domain.usesCase.UseCaseCriptoDatabase
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelCripto @Inject constructor(
    private val getCriptoUseCase: UseCaseCripto,
    private val getCriptoFromDatabaseUseCase: UseCaseCriptoDatabase
) : ViewModel() {

    private val _dataCripto: MutableStateFlow<List<Cripto>> = MutableStateFlow(emptyList())
    val dataCripto: StateFlow<List<Cripto>> = _dataCripto.asStateFlow()

    private val _criptos: MutableStateFlow<List<Cripto>> = MutableStateFlow(emptyList())
    val criptos: StateFlow<List<Cripto>> = _criptos.asStateFlow()

    fun getCriptos() {
        viewModelScope.launch {
            val result = getCriptoUseCase()
            _criptos.value = result.filter { it.name.contains("mxn") }
        }
    }

    fun getCriptosFromDatabase() {
        viewModelScope.launch {
            val result = getCriptoFromDatabaseUseCase()
            if (!result.isNullOrEmpty()) {
                _criptos.value = result.filter { it.name.contains("mxn") }
            }
        }
    }
}
