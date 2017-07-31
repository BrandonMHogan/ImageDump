package com.brandonhogan.imagedump.features.splash

import com.brandonhogan.imagedump.features.shared.base.BaseContract

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

interface SplashContract {

    interface View {
        fun goToMain()
    }

    interface Presenter: BaseContract.Presenter<View, SplashViewModel> {
        fun animationCompleted()
    }

}