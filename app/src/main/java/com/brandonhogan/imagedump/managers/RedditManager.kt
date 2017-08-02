package com.brandonhogan.imagedump.managers

import com.brandonhogan.imagedump.network.RedditAPI
import com.brandonhogan.imagedump.network.responses.RedditResponse
import com.brandonhogan.imagedump.repository.models.DisplayItem
import io.reactivex.Observable
import timber.log.Timber

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     Manager for the reddit API's
 */

class RedditManager constructor(val api: RedditAPI) {

    fun getAwwHot(page: Int = 0): Observable<ArrayList<DisplayItem>> {

        val range = 10
        val placement = page * range

        return Observable.create { subscribe ->

            api.getAwwHot(placement, placement + range).subscribe({ response: RedditResponse ->

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