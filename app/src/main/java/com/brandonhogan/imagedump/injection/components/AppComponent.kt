package com.brandonhogan.imagedump.injection.components

import com.brandonhogan.imagedump.injection.modules.AppModule
import com.brandonhogan.imagedump.injection.modules.NetModule
import com.brandonhogan.imagedump.injection.schedulers.SchedulerProvider
import com.brandonhogan.imagedump.injection.scopes.AppScope
import dagger.Component

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

@AppScope
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {

    val schedulerProvider: SchedulerProvider
}