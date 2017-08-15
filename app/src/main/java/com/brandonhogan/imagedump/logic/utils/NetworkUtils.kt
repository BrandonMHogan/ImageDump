package com.brandonhogan.imagedump.logic.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * @Creator         bhogan
 * @Date            2017-08-11
 * @Description     Connectivity utility shorthand functions for checking network settings
 */

object NetworkUtils {

    /**
     * Checks the network connection to see if the device is on WIFI
     */
    fun isOnWifi(context: Context): Boolean {

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)

        if(networkInfo != null) {
            return networkInfo.isConnected
        }

        return false
    }

}