package com.brandonhogan.imagedump.logic.utils

import android.content.Context
import android.util.DisplayMetrics



/**
 * @Creator         bhogan
 * @Date            2017-08-02
 * @Description     $PARAM$
 */

object Utils {

    fun calculateNoOfColumns(context: Context): Int {
        val displayMetrics = context.getResources().getDisplayMetrics()
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        val noOfColumns = (dpWidth / 180).toInt()
        return noOfColumns
    }

}