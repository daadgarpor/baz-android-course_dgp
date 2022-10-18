package com.example.criptobitsoproyectwz.navigationCompose

sealed class Rutas(var ruta: String) {
    object Home : Rutas("Home")
    object Detalle : Rutas("Detalles")
}
