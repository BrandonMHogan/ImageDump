package com.brandonhogan.imagedump.features.display

import com.brandonhogan.imagedump.features.shared.base.BaseContract
import com.brandonhogan.imagedump.repository.models.DisplayItem

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

interface DisplayContract {

    interface View {
        fun loadMore(items: ArrayList<DisplayItem>, reset: Boolean)
    }

    interface Presenter: BaseContract.Presenter<View, DisplayViewModel> {
        fun loadItems(reset: Boolean)
    }

}