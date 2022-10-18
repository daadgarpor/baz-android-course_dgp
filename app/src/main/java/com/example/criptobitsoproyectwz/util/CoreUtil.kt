package com.example.criptobitsoproyectwz.util

import android.content.Context
import android.net.ConnectivityManager
import com.example.criptobitsoproyectwz.data.repository.CriptoRepository
import javax.inject.Inject

class CoreUtil @Inject constructor(private val context: Context){

    fun checkNetworkStatus(): Boolean {
        var isWifiConnect: Boolean = false
        var isMobileConnet: Boolean = false
        context.let {
            val manager = it.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            manager.allNetworks.forEach { network ->
                manager.getNetworkInfo(network)?.apply {
                    if (type == ConnectivityManager.TYPE_WIFI) {
                        isWifiConnect = isWifiConnect or isConnected
                    }
                    if (type == ConnectivityManager.TYPE_MOBILE) {
                        isMobileConnet = isMobileConnet or isConnected
                    }
                }
            }
        }
        return isWifiConnect || isMobileConnet
    }
}
