package com.brandonhogan.imagedump.features.item

import com.brandonhogan.imagedump.features.shared.base.BasePresenter
import com.brandonhogan.imagedump.logic.injection.schedulers.SchedulerProvider
import com.brandonhogan.imagedump.logic.managers.RedditManager
import javax.inject.Inject

/**
 * @Creator         bhogan
 * @Date            2017-08-02
 * @Description     $PARAM$
 */


class ItemPresenter @Inject constructor(val schedulerProvider: SchedulerProvider, val redditManager: RedditManager) : BasePresenter(), ItemContract.Presenter {

    var view: ItemContract.View? = null
    var model: ItemViewModel? = null

    override fun attach(view: ItemContract.View, model: ItemViewModel) {
        this.view = view
        this.model = model
    }

    override fun detach() {
        this.view = null
    }

}