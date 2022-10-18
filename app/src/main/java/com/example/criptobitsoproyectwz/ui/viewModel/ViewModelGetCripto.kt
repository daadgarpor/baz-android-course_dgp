package com.example.criptobitsoproyectwz.ui.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptobitsoproyectwz.domain.usesCase.GetDataCriptoUseCase
import com.example.criptobitsoproyectwz.domain.usesCase.GetDataCoinUseCase
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin
import com.example.criptobitsoproyectwz.util.CoreUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelGetCripto @Inject constructor(
    private val getCriptoDataGetUseCase: GetDataCriptoUseCase,
    private val getCriptoDataCoinUseCase: GetDataCoinUseCase,
    private val checkNet: CoreUtil

    ) : ViewModel() {

    private val _dataCripto: MutableStateFlow<CriptoCoin> =
        MutableStateFlow(CriptoCoin("", 0.0, 0.0, 0.0))
    val dataCripto: StateFlow<CriptoCoin> = _dataCripto.asStateFlow()

    fun getDataCripto(cripto: String) {
        viewModelScope.launch {
            if (checkNet.checkNetworkStatus()) {
                val result = getCriptoDataGetUseCase(cripto)
                _dataCripto.value = result
            }else{
                val result = getCriptoDataCoinUseCase()
                _dataCripto.value = result!!
            }
        }
    }
}
