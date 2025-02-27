package com.example.criptobitsoproyectwz.ui.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.criptobitsoproyectwz.NavigationCompose.Rutas
import com.example.criptobitsoproyectwz.R
import com.example.criptobitsoproyectwz.Util.convertir
import com.example.criptobitsoproyectwz.data.model.CriptoImage
import com.example.criptobitsoproyectwz.data.model.Criptos.Payload
import com.example.criptobitsoproyectwz.ui.ViewModel.ViewModelCripto
import com.example.criptobitsoproyectwz.ui.ViewModel.ViewModelCriptoLD
import java.text.NumberFormat
import java.util.*


@Composable
fun CriptoScreen(navController: NavHostController, vmCriptoLD: ViewModelCriptoLD) {

    val criptoViewModel = viewModel(modelClass = ViewModelCripto::class.java)
    val listaCriptos by criptoViewModel.dataCripto.collectAsState()

    //LiveData
    //vmCriptoLD.getCriptosLD()
    //val listaCriptos : List<Payload> by vmCriptoLD.listCripto.observeAsState(initial = emptyList())
    val imagelogo = painterResource(R.drawable.bitso)

    Column {
        Card(
            elevation = 4.dp,
            modifier = Modifier.fillMaxWidth().height(150.dp).fillMaxHeight()
                .padding(10.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Image(painter = imagelogo, contentDescription = null)
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize().align(Alignment.CenterHorizontally),
        ) {

            if (listaCriptos.isEmpty()) {
                item() {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(50.dp, 50.dp)
                    )
                }
                //navController.popBackStack()
            }

            items(listaCriptos) { cripto ->
                CriptoCard(cripto, navController)
            }
        }
    }
}

@Composable
fun CriptoCard(cripto: Payload, navController: NavHostController) {
    val imageCrip = CriptoImage()
    val imagePainter = imageCrip.match(cripto = cripto.book)
    val image = painterResource(id = imagePainter)
    val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US)


    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                navController.navigate(route = "${Rutas.Detalle.ruta}/${cripto.book}")
            },
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter =  image,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit,
            )
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = cripto.book.convertir(),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.onSurface,
                )
                Text(
                    text = currencyFormatter.format(cripto.maximo),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}
