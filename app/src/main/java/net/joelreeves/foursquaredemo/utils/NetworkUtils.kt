package net.joelreeves.foursquaredemo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkUtils {
    companion object {
        fun networkIsAvailable(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            val isAvailable = activeNetwork?.isAvailable ?: false
            val isConnected = activeNetwork?.isConnected ?: false
            return isAvailable && isConnected
        }
    }
}