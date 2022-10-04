package com.example.criptobitsoproyectwz.ui.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.criptobitsoproyectwz.NavigationCompose.Rutas
import com.example.criptobitsoproyectwz.R
import com.example.criptobitsoproyectwz.Util.convertir
import com.example.criptobitsoproyectwz.data.model.CriptoImage
import com.example.criptobitsoproyectwz.domain.wrapper.Cripto
import java.text.NumberFormat
import java.util.*

@Composable
fun CriptoScreen(navController: NavHostController, criptos: List<Cripto>) {

    val imagelogo = painterResource(R.drawable.bitso)
    Column {
        Card(
            elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .fillMaxHeight()
                .padding(10.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Image(painter = imagelogo, contentDescription = null)
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally),
        ) {
            if (criptos.isEmpty()) {
                item() {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(50.dp, 50.dp)
                    )
                }
            }
            items(criptos) { cripto ->
                CriptoCard(cripto, navController)
            }
        }
    }

}

@Composable
private fun progress() {
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .height(15.dp),
        backgroundColor = Color.LightGray,
        color = Color.Red //progress color
    )
}

@Composable
fun CriptoCard(cripto: Cripto, navController: NavHostController) {
    val imageCrip = CriptoImage()
    val imagePainter = imageCrip.match(cripto = cripto.name)
    val image = painterResource(id = imagePainter)
    val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US)

    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                navController.navigate(route = "${Rutas.Detalle.ruta}/${cripto.name}")
            },
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit,
            )
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = cripto.name.convertir(),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.onSurface,
                )
                Text(
                    text = cripto.maximum_price.toString(),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}
