package com.brandonhogan.imagedump.features.shared.base

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

interface BaseContract {

    interface Presenter<T, M> {
        fun attach(view: T, model: M)
        fun detach()
    }
}