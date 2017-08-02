package com.brandonhogan.imagedump.logic.network.responses

import com.google.gson.annotations.SerializedName

/**
 * @Creator         bhogan
 * @Date            2017-08-02
 * @Description     $PARAM$
 */

class RedditResponseDataChildrenDataPreview constructor(

    @SerializedName("images")
    var images: ArrayList<RedditResponseDataChildrenDataPreviewImages>

)