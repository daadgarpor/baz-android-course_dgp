package com.example.criptobitsoproyectwz.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptobitsoproyectwz.domain.usesCase.GetInfoCriptoUseCase
import com.example.criptobitsoproyectwz.domain.wrapper.InfoCriptoCoin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelInfoCripto  @Inject constructor(
    private val getCriptoDataGetUseCase: GetInfoCriptoUseCase
) : ViewModel() {

    private val _infoCripto : MutableStateFlow<InfoCriptoCoin> = MutableStateFlow(
        InfoCriptoCoin(emptyList(), emptyList()))
    val infoCripto: StateFlow<InfoCriptoCoin> = _infoCripto.asStateFlow()


    fun getDataCripto(cripto: String) {
        viewModelScope.launch {
            val result = getCriptoDataGetUseCase.getDataCripto(cripto)
            _infoCripto.value = result
        }
    }
}