package com.example.criptobitsoproyectwz.ui.viewModel
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptobitsoproyectwz.domain.usesCase.UseCaseDataCripto
import com.example.criptobitsoproyectwz.domain.usesCase.UseCaseGetDataCoin
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
    private val getCriptoDataUseCase: UseCaseDataCripto,
    private val getCriptoDataCoinUseCase: UseCaseGetDataCoin,

) : ViewModel() {

    private val _dataCripto: MutableStateFlow<CriptoCoin> =
        MutableStateFlow(CriptoCoin("", 0.0, 0.0, 0.0))
    val dataCripto: StateFlow<CriptoCoin> = _dataCripto.asStateFlow()

    fun getDataCripto(cripto: String) {
        viewModelScope.launch {
            if (CoreUtil.checkNetworkStatus()) {
                val result = getCriptoDataUseCase(cripto)
                _dataCripto.value = result
            }else{
                val result = getCriptoDataCoinUseCase()
                _dataCripto.value = result!!
            }
        }
    }
}
