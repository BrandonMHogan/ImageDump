package com.brandonhogan.imagedump.repository.models

/**
 * @Creator         bhogan
 * @Date            2017-08-02
 * @Description     A combined results object for returning api
 */

class DisplayItemCombined constructor(

        var after: String,
        var items: ArrayList<DisplayItem>
)