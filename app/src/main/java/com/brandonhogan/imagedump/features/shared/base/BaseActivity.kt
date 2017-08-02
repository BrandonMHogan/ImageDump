package com.brandonhogan.imagedump.features.shared.base

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import com.brandonhogan.imagedump.R
import com.brandonhogan.imagedump.logic.injection.Injector
import com.brandonhogan.imagedump.logic.injection.components.ActivityComponent
import com.brandonhogan.imagedump.logic.injection.components.DaggerActivityComponent
import timber.log.Timber

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

open class BaseActivity: AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    lateinit var activityComponent: ActivityComponent
        private set

    var isDarkTheme: Boolean = false
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        setDarkTheme()
        super.onCreate(savedInstanceState)
        initActivityComponent()

        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this)
    }

    fun initActivityComponent() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(Injector.appComponent)
                //.navigationModule(NavigationModule(supportFragmentManager))
                .build()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {

        Timber.d("Preference has been changed")

        if (key == getString(R.string.pref_key_theme_dark)) {

            if (sharedPreferences.getBoolean(getString(R.string.pref_key_theme_dark), false)) {
                //  Night theme enabled

                setTheme(R.style.MyDarkTheme)
                application.setTheme(R.style.MyDarkTheme)

            } else {
                setTheme(R.style.MyLightTheme)
                application.setTheme(R.style.MyLightTheme)
            }

            recreate() // This is important. It allows the theme change to take effect.
        }
    }

    private fun setDarkTheme() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        isDarkTheme = prefs.getBoolean(getString(R.string.pref_key_theme_dark), false)

        if(isDarkTheme)
            setTheme(R.style.MyDarkTheme)
        else
            setTheme(R.style.MyLightTheme)
    }

}