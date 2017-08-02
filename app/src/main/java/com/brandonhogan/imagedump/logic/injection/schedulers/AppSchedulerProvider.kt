package com.brandonhogan.imagedump.logic.injection.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @Creator         bhogan
 * @Date            2017-07-07
 * @Description     $PARAM$
 */

class AppSchedulerProvider : SchedulerProvider {
    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun newThread(): Scheduler {
        return Schedulers.newThread()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }
}