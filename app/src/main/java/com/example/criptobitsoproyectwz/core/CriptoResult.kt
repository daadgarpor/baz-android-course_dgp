package com.example.criptobitsoproyectwz.core

import java.lang.Exception


/***
 * reusar clase de tipo generico
 */
sealed class CriptoResult<out T> {
    class Loading<out T> : CriptoResult<T>()
    data class Succes<out T> (val data: T): CriptoResult<T>()
    data class Failure(val exception: String?): CriptoResult<Nothing>()
}