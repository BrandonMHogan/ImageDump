package com.brandonhogan.imagedump.injection.schedulers

import io.reactivex.Scheduler

/**
 * @Creator         bhogan
 * @Date            2017-07-07
 * @Description     $PARAM$
 */

interface SchedulerProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler
}