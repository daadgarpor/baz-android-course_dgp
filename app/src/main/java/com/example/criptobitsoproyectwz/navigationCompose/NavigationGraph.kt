package com.example.criptobitsoproyectwz.navigationCompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import com.example.criptobitsoproyectwz.ui.view.CriptoScreen
import com.example.criptobitsoproyectwz.ui.view.DetallesScreen
import com.example.criptobitsoproyectwz.ui.viewModel.ViewModelGetCripto
import com.example.criptobitsoproyectwz.ui.viewModel.ViewModelInfoCripto

@Composable
fun NavigationGraph(
    criptos: List<Cripto>,
    viewModel: ViewModelGetCripto,
    viewModel3: ViewModelInfoCripto
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Rutas.Home.ruta) {
        composable(route = Rutas.Home.ruta) { CriptoScreen(navController, criptos) }
        composable(
            route = Rutas.Detalle.ruta + "/{cripto}",
            arguments = listOf(navArgument("cripto") { type = NavType.StringType })
        ) { back ->
            back.arguments?.getString("cripto")?.let {
                DetallesScreen(navController, it, viewModel, viewModel3)
            }
        }
    }
}
