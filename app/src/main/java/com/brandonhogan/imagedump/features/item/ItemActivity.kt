package com.brandonhogan.imagedump.features.item

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.ViewTreeObserver
import com.brandonhogan.imagedump.R
import com.brandonhogan.imagedump.features.shared.base.BaseActivity
import com.brandonhogan.imagedump.logic.GlideApp
import com.brandonhogan.imagedump.repository.models.DisplayItem
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_item.*
import javax.inject.Inject

/**
 * @Creator         bhogan
 * @Date            2017-08-02
 * @Description     $PARAM$
 */

class ItemActivity: BaseActivity(), ItemContract.View {

    @Inject
    lateinit var presenter: ItemContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        activityComponent.inject(this)

        val model = ViewModelProviders.of(this).get(ItemViewModel::class.java)
        presenter.attach(this, model)


        val displayItem = intent.getParcelableExtra<DisplayItem>("item")

        title = displayItem.title

        if(displayItem.source.contains(".gif")) {

            GlideApp.with(this)
                    .asGif()
                    .load(displayItem.source)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(image)

        }
        else {

            GlideApp.with(this)
                    .load(displayItem.source)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(image)
        }

        supportPostponeEnterTransition()

        image.getViewTreeObserver().addOnPreDrawListener(
                object : ViewTreeObserver.OnPreDrawListener {
                    override fun onPreDraw(): Boolean {
                        image.getViewTreeObserver().removeOnPreDrawListener(this)
                        supportStartPostponedEnterTransition()
                        return true
                    }
                }
        )

    }

}