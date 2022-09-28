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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/*** ViewModel
 *
 *
 * Conexión entre el modelo y la vista.
 * Las vistas se suscriben a sus viewModels y
 * estos al notar de que el modelo ha sido modificado lo notificarán a la vista.
 */

@HiltViewModel
class ViewModelCripto @Inject constructor (
    private val getCriptoUseCase: useCaseCripto,
    private val getCriptoFromDatabaseUseCase: useCaseCriptoDatabase
    ) : ViewModel() {

    /*** Flow
     * Cualquier objeto que permita que Jetpack Compose se adhiera a
     * cada cambio puede convertirse en State<T> y leerse mediante un elemento que admite composición.
     * manipular informacion, Capa de presentacion
     */
    private val _dataCripto = MutableLiveData<CriptoResult<List<Cripto>>>()
    val dataCripto: LiveData<CriptoResult<List<Cripto>>>  = _dataCripto

    private val _dataCriptoDb = MutableLiveData<CriptoResult<List<Cripto>>>()
    val dataCriptoDb: LiveData<CriptoResult<List<Cripto>>> = _dataCriptoDb


/*    private val _dataCripto = MutableStateFlow(emptyList<Payload>())
    val dataCripto: StateFlow<List<Payload>> = _dataCripto*/

  /*  fun getCriptosss(){
        viewModelScope.launch {
            val result = getCriptoUseCase()
           _dataCripto.update {
               result.body()?.payload?.filter { it.book.contains("mxn") } ?: emptyList()
           }
        }
    }*/

    fun getCriptos(){
        viewModelScope.launch {
            val result = getCriptoUseCase()
           _dataCripto.value = CriptoResult.Loading(true)
            try {
                result?.let {
                    _dataCripto.value = CriptoResult.Succes(it)
                }
            }catch (e: Exception){
                _dataCripto.postValue(CriptoResult.Failure(e))
            }
        }
    }

    fun getCriptosFromDatabase(){
        viewModelScope.launch {
            val result = getCriptoFromDatabaseUseCase()
            if (result != null){
                _dataCriptoDb.postValue(CriptoResult.Succes(result))
            }
        }
    }
}