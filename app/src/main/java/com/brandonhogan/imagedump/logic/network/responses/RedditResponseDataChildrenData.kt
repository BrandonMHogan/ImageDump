package com.brandonhogan.imagedump.logic.network.responses

import com.google.gson.annotations.SerializedName

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     $PARAM$
 */

class RedditResponseDataChildrenData constructor(


        @SerializedName("title")
        var title: String,

        @SerializedName("author")
        var author: String,

        @SerializedName("url")
        var url: String,

        @SerializedName("thumbnail")
        var thumbnail: String,

        @SerializedName("created_utc")
        var created_utc: Long,

        @SerializedName("stickied")
        var stickied: Boolean,

        @SerializedName("preview")
        var preview: RedditResponseDataChildrenDataPreview
)