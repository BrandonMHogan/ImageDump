package com.brandonhogan.imagedump.logic.injection.modules

import com.brandonhogan.imagedump.logic.injection.scopes.AppScope
import com.brandonhogan.imagedump.logic.managers.RedditManager
import com.brandonhogan.imagedump.logic.network.RedditAPI
import dagger.Module
import dagger.Provides

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     $PARAM$
 */

@Module
class UserModule {

    @AppScope
    @Provides
    fun getRedditManager(redditAPI: RedditAPI): RedditManager = RedditManager(redditAPI)

}