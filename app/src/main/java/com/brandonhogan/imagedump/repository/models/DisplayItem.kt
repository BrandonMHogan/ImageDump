package com.brandonhogan.imagedump.repository.models

import com.brandonhogan.imagedump.logic.network.responses.RedditResponse
import com.brandonhogan.imagedump.logic.utils.Utils

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     Main class used for displaying items to the view
 */

class DisplayItem constructor(

    var title: String,
    var author: String,
    var createdUtc: Long,
    var source: String,
    var thumbnail: String,
    var stickied: Boolean

){
    companion object {

        // Loads a reddit response
        fun fromResponse(response: RedditResponse): ArrayList<DisplayItem> {

            val items = response.data.children.map {
                val item = it.data

                var thumbnail = item.thumbnail
                var source = item.preview.images.get(0).source.url

                thumbnail = thumbnail.replace("amp;s", "")
                source = source.replace("amp;s", "")

                DisplayItem(item.title, item.author, item.created_utc, source, thumbnail, item.stickied)
            }

            return ArrayList(items.sortedBy { it.createdUtc })
        }
    }

}