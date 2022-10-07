package com.example.criptobitsoproyectwz.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptobitsoproyectwz.domain.usesCase.CriptoUseCase
import com.example.criptobitsoproyectwz.domain.usesCase.CriptoDatabaseUseCase
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import com.example.criptobitsoproyectwz.util.CoreUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelCripto @Inject constructor(
    private val getCriptoUseCase: CriptoUseCase,
    private val getCriptoFromDatabaseUseCase: CriptoDatabaseUseCase,
    private val checkNet: CoreUtil
) : ViewModel() {

    private val _criptos: MutableStateFlow<List<Cripto>> = MutableStateFlow(emptyList())
    val criptos: StateFlow<List<Cripto>> = _criptos.asStateFlow()

    fun getCriptos() {
        viewModelScope.launch {
            if (checkNet.checkNetworkStatus()) {
                val result = getCriptoUseCase()
                _criptos.value = result.filter { it.name.contains("mxn") }
            } else {
                val result = getCriptoFromDatabaseUseCase()
                if (!result.isNullOrEmpty()) {
                    _criptos.value = result.filter { it.name.contains("mxn") }
                }
            }
        }
    }
}
