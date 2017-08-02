package com.brandonhogan.imagedump.logic.injection.components

import com.brandonhogan.imagedump.logic.injection.modules.AppModule
import com.brandonhogan.imagedump.logic.injection.modules.NetModule
import com.brandonhogan.imagedump.logic.injection.modules.UserModule
import com.brandonhogan.imagedump.logic.injection.schedulers.SchedulerProvider
import com.brandonhogan.imagedump.logic.injection.scopes.AppScope
import com.brandonhogan.imagedump.logic.managers.RedditManager
import dagger.Component

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

@AppScope
@Component(modules = arrayOf(AppModule::class, NetModule::class, UserModule::class))
interface AppComponent {

    val schedulerProvider: SchedulerProvider
    val redditManager: RedditManager
}