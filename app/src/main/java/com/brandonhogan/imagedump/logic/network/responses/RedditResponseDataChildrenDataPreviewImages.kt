package com.brandonhogan.imagedump.logic.network.responses

import com.google.gson.annotations.SerializedName

/**
 * @Creator         bhogan
 * @Date            2017-08-02
 * @Description     $PARAM$
 */

class RedditResponseDataChildrenDataPreviewImages constructor(

        @SerializedName("source")
        var source: RedditResponseDataChildrenDataPreviewImagesItem,

        @SerializedName("resolutions")
        var resolutions: ArrayList<RedditResponseDataChildrenDataPreviewImagesItem>
)