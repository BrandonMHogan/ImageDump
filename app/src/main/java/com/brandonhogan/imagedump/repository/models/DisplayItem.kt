package com.brandonhogan.imagedump.repository.models

import android.os.Parcel
import android.os.Parcelable
import com.brandonhogan.imagedump.logic.network.responses.RedditResponse


/**
 * @Creator         bhogan
 * @Date            2017-08-01
 * @Description     Main class used for displaying items to the view
 */

class DisplayItem constructor(

    var title: String,
    var author: String,
    var createdUtc: Long,
    var source: String,
    var thumbnail: String,
    var stickied: Boolean

) :Parcelable {

    companion object { fun fromResponse(response: RedditResponse): ArrayList<DisplayItem> {

            val items = response.data.children.map {
                val item = it.data

                var thumbnail = item.thumbnail
                var source = item.preview.images[0].source.url

                thumbnail = thumbnail.replace("&amp;s", "&")


                if(item.preview.images[0].variants.gif == null || item.preview.images[0].variants.gif.source.url.isNullOrEmpty())
                    source = source.replace("&amp;s", "&")
                else
                    source = item.preview.images[0].variants.gif.source.url



                DisplayItem(item.title, item.author, item.created_utc, source, thumbnail, item.stickied)
            }

            return ArrayList(items.sortedBy { it.createdUtc })
        }

    @JvmField val CREATOR: Parcelable.Creator<DisplayItem> = object : Parcelable.Creator<DisplayItem> {override fun createFromParcel(source: Parcel): DisplayItem = DisplayItem(source)
    override fun newArray(size: Int): Array<DisplayItem?> =arrayOfNulls(size)}}

        constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readLong(),
            source.readString(),
            source.readString(),
            1 == source.readInt()
        )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {dest.writeString(title)
        dest.writeString(author)
        dest.writeLong(createdUtc)
        dest.writeString(source)
        dest.writeString(thumbnail)
        dest.writeInt((if(stickied) 1 else 0))
    }
}