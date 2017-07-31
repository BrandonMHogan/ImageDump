package com.brandonhogan.imagedump.features.splash

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.brandonhogan.imagedump.R
import com.brandonhogan.imagedump.features.display.DisplayActivity
import com.brandonhogan.imagedump.features.shared.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        activityComponent.inject(this)

        val model = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        presenter.attach(this, model)
    }

    /**
     * Will call startUpAnimation()
     */
    override fun onResume() {
        super.onResume()
        startUpAnimation()
    }

    /**
     * Animates the logo up to the center of the screen
     */
    private fun startUpAnimation() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.splash_in)
        anim.interpolator = AccelerateDecelerateInterpolator()

        anim.fillAfter = true
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                presenter.animationCompleted()
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        logo_icon.startAnimation(anim)
    }

    /**
     * Will load the main activity
     */
    override fun goToMain() {
        startActivity(Intent(this, DisplayActivity::class.java))
        finish()
    }
}