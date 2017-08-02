package com.brandonhogan.imagedump.features.display

import com.brandonhogan.imagedump.features.shared.base.BasePresenter
import com.brandonhogan.imagedump.logic.injection.schedulers.SchedulerProvider
import com.brandonhogan.imagedump.logic.managers.RedditManager
import com.brandonhogan.imagedump.repository.models.DisplayItem
import timber.log.Timber
import javax.inject.Inject

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

class DisplayPresenter @Inject constructor(val schedulerProvider: SchedulerProvider, val redditManager: RedditManager) : BasePresenter(), DisplayContract.Presenter {

    var view: DisplayContract.View? = null
    var model: DisplayViewModel? = null

    override fun attach(view: DisplayContract.View, model: DisplayViewModel) {
        this.view = view
        this.model = model
    }

    override fun detach() {
        this.view = null
    }


    override fun loadItems(reset: Boolean) {

        redditManager.getAwwHot(reset)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({ items: ArrayList<DisplayItem> ->

                    model?.items = ArrayList(items.filter { it.stickied == false })
                    view?.loadMore(items, reset)

                    Timber.d("Made it!")

                }, { error ->
                    Timber.e(error)
                })

    }
}
