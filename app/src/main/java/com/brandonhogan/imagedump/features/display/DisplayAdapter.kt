package com.brandonhogan.imagedump.features.display

import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brandonhogan.imagedump.R
import com.brandonhogan.imagedump.business.GlideApp
import com.brandonhogan.imagedump.repository.models.DisplayItem
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.display_list_item.view.*
import java.lang.Exception

/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     $PARAM$
 */

class DisplayAdapter(val items: ArrayList<DisplayItem>): RecyclerView.Adapter<DisplayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.display_list_item, parent, false)
        return ViewHolder(view)
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

    fun addMore(newItems: ArrayList<DisplayItem>) {
        items.addAll(newItems)
        notifyItemRangeInserted(items.size - newItems.size, newItems.size)
    }

    /**
     * View holder for the property list
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindProperty(item: DisplayItem) {

            with(item) {

                itemView.title.text = title
                itemView.author.text = author


                GlideApp.with(itemView)
                        .load(thumbnail)
                        .centerCrop()
                        .into(itemView.img_thumbnail)

                itemView.time.text = createdUtc.toString()

                itemView.progress.visibility = View.GONE
            }
        }
    }
}