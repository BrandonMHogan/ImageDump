package com.brandonhogan.imagedump.logic.injection.components

import com.brandonhogan.imagedump.features.display.DisplayActivity
import com.brandonhogan.imagedump.features.item.ItemActivity
import com.brandonhogan.imagedump.features.splash.SplashActivity
import com.brandonhogan.imagedump.logic.injection.modules.ActivityModule
import com.brandonhogan.imagedump.logic.injection.scopes.ActivityScope
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
    fun inject(displayActivity: DisplayActivity)
    fun inject(itemActivity: ItemActivity)
}