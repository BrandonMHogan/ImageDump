package com.brandonhogan.imagedump.logic.injection.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.brandonhogan.imagedump.ImagedumpApp
import com.brandonhogan.imagedump.logic.injection.schedulers.AppSchedulerProvider
import com.brandonhogan.imagedump.logic.injection.schedulers.SchedulerProvider
import com.brandonhogan.imagedump.logic.injection.scopes.AppScope
import dagger.Module
import dagger.Provides

/**
 * @Creator         bhogan
 * @Date            2017-06-29
 * @Description     $PARAM$
 */

@Module
class AppModule(var app: ImagedumpApp) {

    @AppScope
    @Provides
    fun provideApp(): ImagedumpApp = app

    @AppScope
    @Provides
    fun provideContext(): Context = app.applicationContext

    @AppScope
    @Provides
    fun provideSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)

    @AppScope
    @Provides
    fun providerAppSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

}
