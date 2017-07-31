package com.brandonhogan.imagedump.features.shared.base

import io.reactivex.disposables.Disposable
import timber.log.Timber

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     Base presenter in which all other presenters should inherit from
 */

open class BasePresenter {

    // TAG used for logging
    val TAG: String = this::class.java.simpleName


    // Disposable list which should be used by child presenters
    // if any observables are being employed (Ex. manager function calls)
    val disposables = ArrayList<Disposable>()

    /**
     * Will loop through and dispose of any subscribes still in use
     *  Should be called from the presenter's onDestroyView
     */
    fun onDestroy() {
        for(disposable in disposables) {
            disposable.dispose()
            Timber.d("Subscribe was disposed ${disposable.isDisposed}")
        }
    }
}