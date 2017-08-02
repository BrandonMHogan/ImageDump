package com.brandonhogan.imagedump.features.display

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.brandonhogan.imagedump.R
import com.brandonhogan.imagedump.features.shared.base.BaseActivity
import javax.inject.Inject
import android.support.v7.widget.RecyclerView
import com.brandonhogan.imagedump.logic.utils.Utils
import com.brandonhogan.imagedump.repository.models.DisplayItem
import kotlinx.android.synthetic.main.activity_display.*


/**
 * @Creator         bhogan
 * @Date            2017-07-31
 * @Description     $PARAM$
 *
 */

class DisplayActivity : BaseActivity(), DisplayContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var presenter: DisplayContract.Presenter

    lateinit private var scrollListener: EndlessRecyclerViewScrollListener
    lateinit private var adapter: DisplayAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        activityComponent.inject(this)

        val model = ViewModelProviders.of(this).get(DisplayViewModel::class.java)
        presenter.attach(this, model)


        // Setup recyclerview
        val layoutManager = GridLayoutManager(this, Utils.calculateNoOfColumns(this))
        display_list.layoutManager = layoutManager

        // Retain an instance so that you can call `resetState()` for fresh searches
        scrollListener = object : EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                presenter.loadItems(reset = false)
            }
        }

        adapter = DisplayAdapter(ArrayList<DisplayItem>())
        display_list.adapter = adapter
        display_list.addOnScrollListener(scrollListener)
        swipe_refresh.setOnRefreshListener(this)

        presenter.loadItems(reset = true)
    }


    override fun onRefresh() {
        scrollListener.resetState()
        presenter.loadItems(reset = true)
    }

    /**
     * Adds the items to the adapter
     */
    override fun loadMore(items: ArrayList<DisplayItem>, reset: Boolean) {
        adapter.addMore(items, reset)
        swipe_refresh.isRefreshing = false
    }
}