package com.example.criptobitsoproyectwz.ui.View

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.criptobitsoproyectwz.NavigationCompose.NavigationGraph
import com.example.criptobitsoproyectwz.R
import com.example.criptobitsoproyectwz.core.CriptoResult
import com.example.criptobitsoproyectwz.data.model.Criptos.Payload
import com.example.criptobitsoproyectwz.ui.ViewModel.ViewModelCripto
import com.example.criptobitsoproyectwz.ui.theme.CriptoBitsoProyectWzTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
      val viewModelCripto : ViewModelCripto by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val criptos by viewModelCripto.criptos.collectAsState()
            CriptoBitsoProyectWzTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                backgroundColor = MaterialTheme.colors.primary,
                                title = { Text(stringResource(R.string.title)) }
                            )
                        }
                    ){

                        Log.d("Prueba", "onCreate: $criptos")
                      // NavigationGraph()
                    }

                }
            }
        }
    }

/*    @Composable
    private fun getlistCripto(): List<Payload>? {
        var list: List<Payload>? = null
        viewModelCripto.getCriptos()

        viewModelCripto.dataCripto.observe(this) { crip ->
            when (crip) {
                is CriptoResult.Loading -> {
                    Log.d("Prueba", "onCreate: ${crip.state}")

                }
                is CriptoResult.Succes -> {
                    Log.d("Prueba", "onCreate: ${crip.data}")
                    list = crip.data.payload.filter { it.book.contains("mxn") }
                }
                is CriptoResult.Failure -> {
                    Log.d("Prueba", "onCreate: ${crip.exception}")
                }
            }
        }
        return list
    }*/


}

