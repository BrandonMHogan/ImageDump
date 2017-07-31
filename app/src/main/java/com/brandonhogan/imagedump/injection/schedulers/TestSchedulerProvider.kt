package com.brandonhogan.imagedump.injection.schedulers

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * @Creator         bhogan
 * @Date            2017-07-07
 * @Description     $PARAM$
 */

class TestSchedulerProvider : SchedulerProvider {
    override fun ui(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun computation(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun newThread(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun io(): Scheduler {
        return Schedulers.trampoline()
    }
}