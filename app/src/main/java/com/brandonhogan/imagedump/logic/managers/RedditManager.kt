package com.brandonhogan.imagedump.logic.managers

import com.brandonhogan.imagedump.logic.network.RedditAPI
import com.brandonhogan.imagedump.logic.network.responses.RedditResponse
import com.brandonhogan.imagedump.repository.models.DisplayItem
import com.brandonhogan.imagedump.repository.models.DisplayItemCombined
import io.reactivex.Observable
import timber.log.Timber

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     Manager for the reddit API's
 */

class RedditManager constructor(val api: RedditAPI) {

    // Keeps track of the after identifier
    var after = ""

    fun getAwwHot(reset: Boolean): Observable<ArrayList<DisplayItem>> {

        if (reset)
            after = ""

        Timber.d("{azza}        after = $after")

        return Observable.create { subscribe ->

            api.getAwwHot(after, "90").subscribe({ response: RedditResponse ->

                after = response.data.after
                val displayItems: ArrayList<DisplayItem> = DisplayItem.fromResponse(response)

                subscribe.onNext(displayItems)
                subscribe.onComplete()

            }, { error ->
                Timber.e(error)
                subscribe.onError(error)
            })

        }
    }
}