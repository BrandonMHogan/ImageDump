package com.brandonhogan.imagedump.logic.network.responses

import com.google.gson.annotations.SerializedName

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     $PARAM$
 */

class RedditResponseData constructor(

        @SerializedName("children")
        var children: ArrayList<RedditResponseDataChildren>,

        @SerializedName("after")
        var after: String,

        @SerializedName("before")
        var before: String
)