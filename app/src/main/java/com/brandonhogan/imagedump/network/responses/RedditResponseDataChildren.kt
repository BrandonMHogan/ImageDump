package com.brandonhogan.imagedump.network.responses

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