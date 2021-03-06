package com.brandonhogan.imagedump.logic.injection.modules

import com.brandonhogan.imagedump.features.display.DisplayContract
import com.brandonhogan.imagedump.features.display.DisplayPresenter
import com.brandonhogan.imagedump.features.item.ItemContract
import com.brandonhogan.imagedump.features.item.ItemPresenter
import com.brandonhogan.imagedump.features.splash.SplashContract
import com.brandonhogan.imagedump.features.splash.SplashPresenter
import com.brandonhogan.imagedump.logic.injection.schedulers.SchedulerProvider
import com.brandonhogan.imagedump.logic.injection.scopes.ActivityScope
import com.brandonhogan.imagedump.logic.managers.RedditManager
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

    @ActivityScope
    @Provides
    fun provideItemPresenter(redditManager: RedditManager, schedulerProvider: SchedulerProvider): ItemContract.Presenter {
        return ItemPresenter(schedulerProvider, redditManager)
    }
}