package com.brandonhogan.imagedump.features.display

import com.brandonhogan.imagedump.features.shared.base.BasePresenter
import com.brandonhogan.imagedump.injection.schedulers.SchedulerProvider
import javax.inject.Inject

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

class DisplayPresenter @Inject constructor(val schedulerProvider: SchedulerProvider) : BasePresenter(), DisplayContract.Presenter {

    var view: DisplayContract.View? = null
    var model: DisplayViewModel? = null

    override fun attach(view: DisplayContract.View, model: DisplayViewModel) {
        this.view = view
        this.model = model
    }

    override fun detach() {
        this.view = null
    }


}
