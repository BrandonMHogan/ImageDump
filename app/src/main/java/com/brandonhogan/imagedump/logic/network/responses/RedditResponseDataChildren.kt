package com.brandonhogan.imagedump.logic.network.responses

import com.google.gson.annotations.SerializedName

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     $PARAM$
 */

class RedditResponseDataChildren constructor(

        @SerializedName("data")
        var data: RedditResponseDataChildrenData
)