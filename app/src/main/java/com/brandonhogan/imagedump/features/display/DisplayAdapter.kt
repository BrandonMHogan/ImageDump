package com.brandonhogan.imagedump.features.display

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brandonhogan.imagedump.R
import com.brandonhogan.imagedump.logic.GlideApp
import com.brandonhogan.imagedump.repository.models.DisplayItem
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.display_list_item.view.*
import timber.log.Timber



/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     $PARAM$
 */

class DisplayAdapter(val items: ArrayList<DisplayItem>, val isOnWifi: Boolean = false, val itemClick: (DisplayItem, View) -> Unit): RecyclerView.Adapter<DisplayAdapter.ViewHolder>() {

    private val LOAD_ATTEMPTS = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.display_list_item, parent, false)
        return ViewHolder(view, LOAD_ATTEMPTS, isOnWifi, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProperty(items[position])
    }

    override fun getItemCount() = items.size

    /**
     * Removes an item from the stored values and notifies the adapter of the change
     */
    fun remove(item: DisplayItem): Boolean {
        items.removeAt(items.indexOf(item))
        notifyDataSetChanged()

        return items.isEmpty()
    }

    fun addMore(newItems: ArrayList<DisplayItem>, reset: Boolean = false) {

        // Will clear the current items from the list first
        if (reset)
            items.clear()

        items.addAll(newItems)
        notifyDataSetChanged()
        //notifyItemRangeInserted(items.size - newItems.size, newItems.size)
    }

    /**
     * View holder for the property list
     */
    class ViewHolder(view: View, val loadAttempts: Int = 1, val isOnWifi: Boolean, val itemClick: (DisplayItem, View) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindProperty(item: DisplayItem) {

            with(item) {
                itemView.progress.visibility = View.VISIBLE

                // Will try and load the thumbnail and source
                tryToLoad(loadAttempts, thumbnail, source)

                itemView.setOnClickListener {

                    //GlideApp.with(itemView).load(source).into(itemView.image)
                    itemClick(this, itemView.image) }
            }
        }


        /**
         * Will try and load the image. If it fails, will try again until tries = 0
         */
        fun tryToLoad(tries: Int, thumbnail: String, source: String = "") {

            if(tries > 0) {

                GlideApp.with(itemView)
                        .load(thumbnail)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .listener(object : RequestListener<Drawable> {

                            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                                itemView.progress.visibility = View.GONE

                                target!!.getSize { width, height ->
                                    GlideApp.with(itemView).load(source).preload(width, height)
                                }

                                if (isOnWifi) {
                                    Timber.d("{bbvb}     Is on wifi. Pre loading Source = $source")
                                    GlideApp.with(itemView)
                                            .load(source)
                                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                                            .preload()
                                }

                                return false
                            }

                            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {

                                Timber.d("{bbvb}     Failed to load. With $tries remaining")
                                // Will try and load the image a second time
                                tryToLoad(tries - 1, thumbnail, source)
                                return false
                            }

                        })
                        .into(itemView.image)

            }
            // Will only be accessed if image failed to load more then the tries times
            else {
                Timber.d("{bbvb}     Failed to load. With $tries remaining.")
                itemView.progress.visibility = View.GONE
            }
        }
    }
}