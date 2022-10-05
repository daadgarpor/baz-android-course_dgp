package com.example.criptobitsoproyectwz.util

import android.content.Context
import android.net.ConnectivityManager

object CoreUtil {
    var context: Context? = null

    fun checkNetworkStatus(): Boolean {
        var isWifiConnect: Boolean = false
        var isMobileConnet: Boolean = false
        context?.let {
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
