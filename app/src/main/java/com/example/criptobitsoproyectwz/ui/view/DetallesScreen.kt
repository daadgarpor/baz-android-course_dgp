package com.example.criptobitsoproyectwz.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.criptobitsoproyectwz.data.model.CriptoImage
import com.example.criptobitsoproyectwz.data.model.orderBook.Asks
import com.example.criptobitsoproyectwz.data.model.orderBook.Bids
import com.example.criptobitsoproyectwz.domain.wrapper.CriptoCoin
import com.example.criptobitsoproyectwz.ui.viewModel.ViewModelGetCripto
import com.example.criptobitsoproyectwz.ui.viewModel.ViewModelInfoCripto
import java.text.NumberFormat
import java.util.*

@Composable
fun DetallesScreen(
    navController: NavHostController,
    cripto: String,
    viewModel: ViewModelGetCripto,
    viewModel3: ViewModelInfoCripto
) {
    viewModel.getDataCripto(cripto)
    val info by viewModel.dataCripto.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (info.book.isNullOrBlank()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp, 50.dp)
            )
        } else {
            CardDetalle(cripto, info)
           // OtraFORMA(cripto = cripto, viewModel3)
        }
    }
}

@Composable
fun OtraFORMA(cripto: String, viewModel3: ViewModelInfoCripto) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
    ) {
        Ask(modifier = Modifier.weight(1f), viewModel3, cripto)
        Spacer(modifier = Modifier.width(5.dp))
        Bids(cripto = cripto, modifier = Modifier.weight(1f), viewModel3)
    }
}

@Composable
fun Ask(modifier: Modifier = Modifier, viewModel3: ViewModelInfoCripto, cripto: String) {
    viewModel3.getDataCripto(cripto = cripto)
    val asks by viewModel3.infoCripto.collectAsState()

    LazyColumn(modifier = modifier) {
        if (asks.asks.isNullOrEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(50.dp, 50.dp)
                )
            }
        }
        items(asks.asks) { list ->
            cardAsks(list)
        }
    }
}

@Composable
fun Bids(cripto: String, modifier: Modifier = Modifier, viewModel3: ViewModelInfoCripto) {
    viewModel3.getDataCripto(cripto)
    val bids by viewModel3.infoCripto.collectAsState()

    LazyColumn(modifier = modifier) {
        if (bids.bids.isNullOrEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(50.dp, 50.dp)
                )
            }
        }

        items(bids.bids) { list ->
            cardBids(list)
        }
    }
}

@Composable
private fun cardBids(list: Bids) {
    val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US)
    Card(
        modifier = Modifier
            .padding(start = 2.dp, bottom = 10.dp, end = 6.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = 5.dp,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.padding(2.dp)) {
                Text(
                    text = "Price:${currencyFormatter.format(list.price)}",
                    color = Color.Black,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = "Amount: ${currencyFormatter.format(list.amount)}",
                    color = Color.Black,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
            }
        }
    }
}

@Composable
private fun cardAsks(list: Asks) {
    val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US)
    Card(
        modifier = Modifier
            .padding(start = 2.dp, bottom = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = "Price:${currencyFormatter.format(list.price)}",
                    color = Color.Black,
                    fontSize = 10.sp
                )
                Text(
                    text = "Amount:${currencyFormatter.format(list.amount)}",
                    color = Color.Black,
                    fontSize = 10.sp

                )
            }
        }
    }
}

@Composable
fun CardDetalle(cripto: String, info: CriptoCoin) {
    val imageCrip = CriptoImage()
    val imagePainter = imageCrip.match(cripto = cripto)
    val image = painterResource(id = imagePainter)

    val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US)
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .padding(8.dp),
            contentScale = ContentScale.Fit
        )
        Column(Modifier.padding(8.dp)) {
            Text(
                text = cripto,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colors.onSurface
            )
            Text(
                text = "High: ${currencyFormatter.format(info.high)}",
                style = MaterialTheme.typography.overline,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Low: ${currencyFormatter.format(info.low)}",
                style = MaterialTheme.typography.overline,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Last: ${currencyFormatter.format(info.last)}",
                style = MaterialTheme.typography.overline,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(1f)
    ) {
        Text(
            text = "Ask",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Text(
            text = "Bids",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}
