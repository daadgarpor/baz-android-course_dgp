package com.example.criptobitsoproyectwz.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptobitsoproyectwz.core.CriptoResult
import com.example.criptobitsoproyectwz.domain.usesCase.CriptoUseCase
import com.example.criptobitsoproyectwz.domain.usesCase.CriptoDatabaseUseCase
import com.example.criptobitsoproyectwz.domain.usesCase.CriptoRxUseCase
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import com.example.criptobitsoproyectwz.util.CoreUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelCripto @Inject constructor(
    private val getCriptoUseCase: CriptoUseCase,
    private val getCriptoFromDatabaseUseCase: CriptoDatabaseUseCase,
    private val getCriptosRxUseCase: CriptoRxUseCase,

    private val checkNet: CoreUtil
) : ViewModel() {

    private val _criptos: MutableStateFlow<List<Cripto>> = MutableStateFlow(emptyList())
    val criptos: StateFlow<List<Cripto>> = _criptos.asStateFlow()

    private val _criptosRx: MutableStateFlow<CriptoResult<List<Cripto>>> = MutableStateFlow(CriptoResult.Loading())
    val criptoRx: StateFlow<CriptoResult<List<Cripto>>> = _criptosRx.asStateFlow()


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

    fun getCriptoRx(){
        val result = getCriptosRxUseCase()
        result.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { onSucces: List<Cripto>?, onError: Throwable? ->
                onSucces?.let {
                    _criptosRx.value = CriptoResult.Succes(it)
                }

                onError.let {
                    if (it != null) {
                        _criptosRx.value = CriptoResult.Failure(it.message)
                    }
                }


            }
    }
}
