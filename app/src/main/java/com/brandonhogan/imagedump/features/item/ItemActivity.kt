package com.brandonhogan.imagedump.features.item

import android.arch.lifecycle.ViewModelProviders
import android.graphics.drawable.Drawable
import android.os.Bundle
import com.brandonhogan.imagedump.R
import com.brandonhogan.imagedump.features.shared.base.BaseActivity
import com.brandonhogan.imagedump.logic.GlideApp
import com.brandonhogan.imagedump.repository.models.DisplayItem
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_item.*
import timber.log.Timber
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

        val viewModel = ViewModelProviders.of(this).get(ItemViewModel::class.java)
        presenter.attach(this, viewModel)


        val displayItem = intent.getParcelableExtra<DisplayItem>("item")
        title = displayItem.title

        if(displayItem.source.contains(".gif")) {
            loadGif(displayItem.source)
        }
        else {
            loadImage(displayItem.source)
        }
    }

    /**
     * Loads the image source
     */
    fun loadImage(source: String) {

        supportPostponeEnterTransition()

        GlideApp.with(this)
                .load(source)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(object: RequestListener<Drawable> {
                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        supportStartPostponedEnterTransition()
                        return false
                    }

                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        Timber.e("Image failed $model,    $e")
                        supportStartPostponedEnterTransition()
                        return false
                    }
                })
                .into(image)
    }

    /**
     * Loads the gif source
     */
    fun loadGif(source: String) {

        GlideApp.with(this)
                .asGif()
                .load(source)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image)
    }

}