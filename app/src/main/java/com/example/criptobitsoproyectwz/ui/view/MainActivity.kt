package com.example.criptobitsoproyectwz.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModelProvider
import com.example.criptobitsoproyectwz.navigationCompose.NavigationGraph
import com.example.criptobitsoproyectwz.R
import com.example.criptobitsoproyectwz.core.CriptoResult
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import com.example.criptobitsoproyectwz.ui.viewModel.ViewModelCripto
import com.example.criptobitsoproyectwz.ui.viewModel.ViewModelGetCripto
import com.example.criptobitsoproyectwz.ui.viewModel.ViewModelInfoCripto
import com.example.criptobitsoproyectwz.ui.theme.CriptoBitsoProyectWzTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModelCripto: ViewModelCripto by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
       /*     viewModelCripto.getCriptos()
            val criptos by viewModelCripto.criptos.collectAsState()*/

            viewModelCripto.getCriptoRx()
            val criptosRx by viewModelCripto.criptoRx.collectAsState()

            val viewModel = ViewModelProvider(this)[ViewModelGetCripto::class.java]
            val viewModel3 = ViewModelProvider(this)[ViewModelInfoCripto::class.java]
            CriptoApp(criptosRx, viewModel, viewModel3)
        }
    }

    @Composable
    private fun CriptoApp(
        criptos: CriptoResult<List<Cripto>>,
        viewModel: ViewModelGetCripto,
        viewModel3: ViewModelInfoCripto
    ) {
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
                    NavigationGraph(criptos = criptos, viewModel, viewModel3)
                }
            }
        }
    }
}

