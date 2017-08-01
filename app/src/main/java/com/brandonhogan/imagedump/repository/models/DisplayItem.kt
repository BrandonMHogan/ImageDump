package com.brandonhogan.imagedump.repository.models

import com.brandonhogan.imagedump.network.responses.RedditResponse
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONArray


/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     $PARAM$
 */

class DisplayItem constructor(

    var title: String,
    var author: String,
    var createdUtc: Long,
    var url: String,
    var thumbnail: String

){
    companion object {

        fun fromResponse(response: RedditResponse): ArrayList<DisplayItem> {

            val items = response.data.children.map {
                val item = it.data

                DisplayItem(item.title, item.author, item.created_utc, item.url, item.thumbnail)
            }

            return ArrayList(items.sortedBy { it.createdUtc })
        }
    }

}