package com.brandonhogan.imagedump

import android.app.Application
import com.brandonhogan.imagedump.logic.injection.Injector
import com.google.android.gms.ads.MobileAds
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     Main application singleton class
 */

class ImagedumpApp: Application() {

    override fun onCreate() {
        super.onCreate()

        // Leak Canary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)


        // DI
        Injector.initGlobalComponents(this)

        // Logging
        Timber.plant(Timber.DebugTree())

        // Admob
        MobileAds.initialize(this, getString(R.string.admob_app_id))

    }

}