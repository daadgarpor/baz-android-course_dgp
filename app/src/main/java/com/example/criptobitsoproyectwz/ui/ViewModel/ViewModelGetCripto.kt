package com.example.criptobitsoproyectwz.ui.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptobitsoproyectwz.domain.usesCase.UseCaseDataCripto
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelGetCripto @Inject constructor(
    private val getCriptoDataUseCase: UseCaseDataCripto
) : ViewModel() {

    private val _dataCripto: MutableStateFlow<CriptoCoin> =
        MutableStateFlow(CriptoCoin("", 0.0, 0.0, 0.0))
    val dataCripto: StateFlow<CriptoCoin> = _dataCripto.asStateFlow()

    fun getDataCripto(cripto: String) {
        viewModelScope.launch {
            val result = getCriptoDataUseCase.getDataCripto(cripto)
            Log.d("INFO", "getDataCripto: $result")
            _dataCripto.value = result
        }
    }

}