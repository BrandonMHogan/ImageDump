package com.brandonhogan.imagedump.injection.components

import com.brandonhogan.imagedump.features.display.DisplayActivity
import com.brandonhogan.imagedump.features.splash.SplashActivity
import com.brandonhogan.imagedump.injection.modules.ActivityModule
import com.brandonhogan.imagedump.injection.scopes.ActivityScope
import dagger.Component

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(splashActivity: SplashActivity)
    fun inject(introActivity: DisplayActivity)
}