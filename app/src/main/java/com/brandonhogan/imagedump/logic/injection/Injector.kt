package com.brandonhogan.imagedump.logic.injection

import com.brandonhogan.imagedump.ImagedumpApp
import com.brandonhogan.imagedump.logic.injection.components.AppComponent
import com.brandonhogan.imagedump.logic.injection.components.DaggerAppComponent
import com.brandonhogan.imagedump.logic.injection.modules.AppModule

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

object Injector {

    // The main component
    lateinit var appComponent: AppComponent
        private set

    /**
     * Inits the main components that last the entire application lifecycle.
     *      Should only be called from the application class itself on setup
     */
    fun initGlobalComponents(app: ImagedumpApp) {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(app))
                .build()
    }
}