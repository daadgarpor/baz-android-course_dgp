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
import com.example.criptobitsoproyectwz.Util.CoreUtil
import com.example.criptobitsoproyectwz.ui.ViewModel.ViewModelCripto
import com.example.criptobitsoproyectwz.ui.ViewModel.ViewModelGetCripto
import com.example.criptobitsoproyectwz.ui.theme.CriptoBitsoProyectWzTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModelCripto: ViewModelCripto by viewModels()
    val viewModelCripto2: ViewModelGetCripto by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoreUtil.context = applicationContext
        setContent {
            viewModelCripto.getCriptos()
            val criptos by viewModelCripto.criptos.collectAsState()

            viewModelCripto2.getDataCripto("xrp_mxn")
            val cr by viewModelCripto2.dataCripto.collectAsState()
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
                    ) {
                        Log.d("INFO", "onCreate: $cr")
                        NavigationGraph(criptos = criptos)
                    }

                }
            }
        }
    }

}

