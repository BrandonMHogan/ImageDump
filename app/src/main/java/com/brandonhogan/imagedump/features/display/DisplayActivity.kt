package com.brandonhogan.imagedump.features.display

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.brandonhogan.imagedump.R
import com.brandonhogan.imagedump.features.shared.base.BaseActivity
import javax.inject.Inject

/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 */

class DisplayActivity : BaseActivity(), DisplayContract.View {

    @Inject
    lateinit var presenter: DisplayContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        activityComponent.inject(this)

        val model = ViewModelProviders.of(this).get(DisplayViewModel::class.java)
        presenter.attach(this, model)
    }
}