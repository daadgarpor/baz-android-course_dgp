package com.example.criptobitsoproyectwz.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptobitsoproyectwz.domain.usesCase.AskDatabaseUseCase
import com.example.criptobitsoproyectwz.domain.usesCase.GetInfoCriptoUseCase
import com.example.criptobitsoproyectwz.domain.wrapper.AsksCoin
import com.example.criptobitsoproyectwz.domain.wrapper.InfoCriptoCoin
import com.example.criptobitsoproyectwz.util.CoreUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelInfoCripto  @Inject constructor(
    private val getCriptoDataGetUseCase: GetInfoCriptoUseCase,
    private val getAsksUseCase: AskDatabaseUseCase,
    private val checkNet: CoreUtil
) : ViewModel() {

    private val _infoCripto : MutableStateFlow<InfoCriptoCoin> = MutableStateFlow(
        InfoCriptoCoin(emptyList(), emptyList()))
    val infoCripto: StateFlow<InfoCriptoCoin> = _infoCripto.asStateFlow()

    private var _ask : MutableStateFlow<List<AsksCoin>?> = MutableStateFlow(emptyList())
    val ask: StateFlow<List<AsksCoin>?> = _ask.asStateFlow()

    fun getDataCripto(cripto: String) {
        viewModelScope.launch {

                val result = getCriptoDataGetUseCase.getDataCripto(cripto)
                _infoCripto.value = result

        }
    }
}