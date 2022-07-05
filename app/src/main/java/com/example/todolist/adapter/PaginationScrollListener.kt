package com.example.todolist.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationScrollListener : RecyclerView.OnScrollListener() {

    private lateinit var mLayoutManager: LinearLayoutManager

    fun initData(mLayoutManager: LinearLayoutManager) {
        this.mLayoutManager = mLayoutManager
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = mLayoutManager.childCount
        val totalItemCount = mLayoutManager.itemCount
        val firstVisibleItemPos = mLayoutManager.findFirstVisibleItemPosition()

        if (isLoading() || isLastPage()) {
            return
        }
        if (firstVisibleItemPos >= 0 && visibleItemCount + firstVisibleItemPos >= totalItemCount) {
            loadMoreItem()

        }
    }

    public abstract fun loadMoreItem();
    public abstract fun isLoading(): Boolean
    public abstract fun isLastPage(): Boolean
}