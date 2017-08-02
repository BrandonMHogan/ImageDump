package com.brandonhogan.imagedump.repository.models

import com.brandonhogan.imagedump.logic.network.responses.RedditResponse

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     Main class used for displaying items to the view
 */

class DisplayItem constructor(

    var title: String,
    var author: String,
    var createdUtc: Long,
    var url: String,
    var thumbnail: String,
    var stickied: Boolean

){
    companion object {

        // Loads a reddit response
        fun fromResponse(response: RedditResponse): ArrayList<DisplayItem> {

            val items = response.data.children.map {
                val item = it.data
                DisplayItem(item.title, item.author, item.created_utc, item.url, item.thumbnail, item.stickied)
            }

            return ArrayList(items.sortedBy { it.createdUtc })
        }
    }

}