package com.brandonhogan.imagedump.features.splash

import com.brandonhogan.imagedump.features.shared.base.BasePresenter
import javax.inject.Inject

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     presenter for the splash activity
 */

class SplashPresenter @Inject constructor() : BasePresenter(), SplashContract.Presenter {

    var view: SplashContract.View? = null
    var model: SplashViewModel? = null

    override fun attach(view: SplashContract.View, model: SplashViewModel) {
        this.view = view
        this.model = model
    }

    override fun detach() {
        this.view = null
    }

    /**
     * The splash activity has an animation effect on the UI thread.
     *  It will call this function once the animation is done
     */
    override fun animationCompleted() {
        model?.animationComplete = true
        view?.goToMain()
    }
}
