package com.brandonhogan.imagedump.injection.modules

import com.brandonhogan.imagedump.features.display.DisplayContract
import com.brandonhogan.imagedump.features.display.DisplayPresenter
import com.brandonhogan.imagedump.features.splash.SplashContract
import com.brandonhogan.imagedump.features.splash.SplashPresenter
import com.brandonhogan.imagedump.injection.schedulers.SchedulerProvider
import com.brandonhogan.imagedump.injection.scopes.ActivityScope
import com.brandonhogan.imagedump.managers.RedditManager
import dagger.Module
import dagger.Provides

/**
 * @Creator         bhogan
 * @Date            2017-07-02
 * @Description     $PARAM$
 */

@Module
class ActivityModule {

    @ActivityScope
    @Provides
    fun provideSplashPresenter(): SplashContract.Presenter {
        return SplashPresenter()
    }

    @ActivityScope
    @Provides
    fun provideDisplayPresenter(redditManager: RedditManager, schedulerProvider: SchedulerProvider): DisplayContract.Presenter {
        return DisplayPresenter(schedulerProvider, redditManager)
    }
}