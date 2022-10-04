package com.example.criptobitsoproyectwz.ui.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.criptobitsoproyectwz.NavigationCompose.NavigationGraph
import com.example.criptobitsoproyectwz.R
import com.example.criptobitsoproyectwz.Util.CoreUtil
import com.example.criptobitsoproyectwz.ui.ViewModel.ViewModelCripto
import com.example.criptobitsoproyectwz.ui.ViewModel.ViewModelGetCripto
import com.example.criptobitsoproyectwz.ui.ViewModel.ViewModelInfoCripto
import com.example.criptobitsoproyectwz.ui.theme.CriptoBitsoProyectWzTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModelCripto: ViewModelCripto by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoreUtil.context = applicationContext
        setContent {

            viewModelCripto.getCriptos()
            val criptos by viewModelCripto.criptos.collectAsState()

            val viewModel = ViewModelProvider(this)[ViewModelGetCripto::class.java]

            val viewModel3 = ViewModelProvider(this)[ViewModelInfoCripto::class.java]

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

    @Composable
    fun LinearVertical() {
        Column(modifier = Modifier.padding(16.dp)) {
            for (i in 0..10) {
                Text(text = "elemento $i")
            }

        }
    }

    @Preview
    @Composable
    fun LinearHorizontal() {
        Row(modifier = Modifier.padding(16.dp)) {
            for (i in 0..10) {
                Text(text = "elemento $i")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Previewss() {
        LinearVertical()
        LinearHorizontal()
    }


}

