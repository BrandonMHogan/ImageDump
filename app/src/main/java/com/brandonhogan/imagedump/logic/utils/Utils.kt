package com.brandonhogan.imagedump.logic.utils

import android.content.Context

/**
 * @Creator         bhogan
 * @Date            2017-08-02
 * @Description     $PARAM$
 */

object Utils {


    fun calculateNoOfColumns170(context: Context): Int {
        val displayMetrics = context.getResources().getDisplayMetrics()
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        val noOfColumns = (dpWidth / 170).toInt()
        return noOfColumns
    }

    fun calculateNoOfColumns130(context: Context): Int {
        val displayMetrics = context.getResources().getDisplayMetrics()
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        val noOfColumns = (dpWidth / 130).toInt()
        return noOfColumns
    }

}