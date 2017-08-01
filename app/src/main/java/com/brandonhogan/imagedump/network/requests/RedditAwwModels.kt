package com.brandonhogan.imagedump.network.requests

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     $PARAM$
 */

class RedditAwwResponse(val data: RedditDataResponse)

class RedditDataResponse(
        val children: List<RedditChildrenResponse>,
        val after: String?,
        val before: String?
)

class RedditChildrenResponse(val data: RedditAwwDataResponse)

data class RedditAwwDataResponse(
        val author: String,
        val title: String,
        val created_utc: Long,
        val url: String,
        val resolutions : List<Resolutions>,
        val gifs : List<Resolutions>
)

data class Resolutions(
        val url: String,
        val width: Int,
        val height: Int
)