package com.brandonhogan.imagedump.features.item

import com.brandonhogan.imagedump.features.shared.base.BaseContract

/**
 * @Creator         bhogan
 * @Date            2017-08-02
 * @Description     $PARAM$
 */


interface ItemContract {

    interface View {
    }

    interface Presenter: BaseContract.Presenter<View, ItemViewModel> {

    }

}