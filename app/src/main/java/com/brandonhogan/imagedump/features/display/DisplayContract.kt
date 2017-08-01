package com.brandonhogan.imagedump.features.display

import com.brandonhogan.imagedump.features.shared.base.BaseContract

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

interface DisplayContract {

    interface View {

    }

    interface Presenter: BaseContract.Presenter<View, DisplayViewModel> {
        fun loadMore(page: Int)
    }

}