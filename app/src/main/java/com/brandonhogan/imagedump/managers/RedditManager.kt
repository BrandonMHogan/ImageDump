package com.brandonhogan.imagedump.managers

import com.brandonhogan.imagedump.network.RedditAPI
import com.brandonhogan.imagedump.network.responses.RedditResponse
import com.brandonhogan.imagedump.repository.models.DisplayItem
import io.reactivex.Observable
import timber.log.Timber

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     $PARAM$
 */

class RedditManager constructor(val api: RedditAPI) {

    fun getAwwHot(): Observable<ArrayList<DisplayItem>> {

        return Observable.create { subscribe ->

            api.getAwwHot("0", "2").subscribe({ response: RedditResponse ->

                val displayItems: ArrayList<DisplayItem> = DisplayItem.fromResponse(response)



//                val data: JSONObject = response.getJSONObject("data")
//                val items: JSONArray = data.getJSONArray("children")
//
//                val displayItems: ArrayList<DisplayItem> = DisplayItem.fromJson(items)

                subscribe.onNext(displayItems)
                subscribe.onComplete()

            }, { error ->
                Timber.e(error)
                subscribe.onError(Throwable("Shit went wrong"))
            })

        }
    }

}