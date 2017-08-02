package com.brandonhogan.imagedump.logic.network.responses

import com.google.gson.annotations.SerializedName

/**
 * @Creator         bhogan
 * @Date            2017-08-02
 * @Description     $PARAM$
 */

class RedditResponseDataChildrenDataPreviewImagesItem constructor(

        @SerializedName("url")
        var url: String,

        @SerializedName("width")
        var width: Int,

        @SerializedName("height")
        var height: Int

)