package com.brandonhogan.imagedump.injection.modules

import com.brandonhogan.imagedump.injection.scopes.AppScope
import com.brandonhogan.imagedump.managers.RedditManager
import com.brandonhogan.imagedump.network.RedditAPI
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