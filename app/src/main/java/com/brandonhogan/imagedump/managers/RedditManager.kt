package com.brandonhogan.imagedump.managers

import com.brandonhogan.imagedump.network.RedditAPI
import com.brandonhogan.imagedump.network.requests.RedditAwwResponse
import com.brandonhogan.imagedump.repository.models.DisplayItem
import io.reactivex.Observable
import timber.log.Timber

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     $PARAM$
 */

class RedditManager constructor(val api: RedditAPI) {

    fun getAwwHot(): Observable<DisplayItem> {

        return Observable.create { subscribe ->

            api.getAwwHot("0", "10").subscribe({ response: RedditAwwResponse ->

                Timber.d(response.data.children.get(0).data.author)
                Timber.d(response.data.children.get(0).data.title)

                Timber.d(response.toString())
                subscribe.onNext(DisplayItem(1, "title", "desc", "source"))
                subscribe.onComplete()

            }, { error ->
                Timber.e(error)
                subscribe.onError(Throwable("Shit went wrong"))
            })

        }
    }

}