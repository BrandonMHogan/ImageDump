package com.brandonhogan.imagedump.logic.network

import com.brandonhogan.imagedump.logic.network.responses.RedditResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     API endpoints for reddit
 */

interface RedditAPI {

    // Aww subreddit
    @GET("/r/aww/hot.json")
    fun getAwwHot(@Query("after") after: String, @Query("limit") limit: String): Observable<RedditResponse>

}