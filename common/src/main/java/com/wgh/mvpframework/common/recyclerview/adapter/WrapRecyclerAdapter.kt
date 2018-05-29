package com.wgh.mvpframework.common.recyclerview.adapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup

/**
 * Create by wgh on 2018/5/29.
 * Description:
 */
class WrapRecyclerAdapter (private val mAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mHeaderViews: SparseArray<View> = SparseArray()
    private var mFooterViews: SparseArray<View> = SparseArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (isHeaderViewType(viewType)){
            val headerView = mHeaderViews.get(viewType)
            return createHeaderFooterViewHolder(headerView)
        }
        if (isFooterViewType(viewType)){
            val footerView = mFooterViews.get(viewType)
            return createHeaderFooterViewHolder(footerView)
        }
        return mAdapter.onCreateViewHolder(parent, viewType)

    }


    override fun getItemCount(): Int {
        return mAdapter.itemCount + mHeaderViews.size() + mFooterViews.size()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isHeaderPosition(position) || isFooterPosition(position)){
            return
        }

        val pos = position - mHeaderViews.size()
        mAdapter.onBindViewHolder(holder, pos)
    }

    override fun getItemViewType(position: Int): Int {
        if (isHeaderPosition(position)){
            return mHeaderViews.keyAt(position)
        }
        if (isFooterPosition(position)){
            val key = position - mHeaderViews.size() - mAdapter.itemCount
            return mFooterViews.keyAt(key)
        }
        val pos = position - mHeaderViews.size()
        return mAdapter.getItemViewType(pos)
    }

    private fun isHeaderViewType(viewType: Int): Boolean = mHeaderViews.indexOfKey(viewType) >= 0

    private fun isFooterViewType(viewType: Int): Boolean = mFooterViews.indexOfKey(viewType) >= 0

    private fun createHeaderFooterViewHolder(view: View) : RecyclerView.ViewHolder{
        return object : RecyclerView.ViewHolder(view){}
    }

    /**
     * 是不是头部位置
     */
    private fun isHeaderPosition(position: Int): Boolean = position < mHeaderViews.size()

    /**
     * 是不是尾部位置
     */
    private fun isFooterPosition(position: Int): Boolean = position >= mHeaderViews.size() + mAdapter.itemCount

    /**
     * 添加头部View
     */
    fun addHeaderView(view: View){
        val position = mHeaderViews.indexOfValue(view)
        if (position < 0){
            mHeaderViews.put(BASE_ITEM_TYPE_HEADER++, view)
        }
        notifyDataSetChanged()
    }

    /**
     * 移除头部View
     */
    fun removeHeaderView(view: View){
        val index = mHeaderViews.indexOfValue(view)
        if (index > 0){
            mHeaderViews.removeAt(index)
            notifyDataSetChanged()
        }
    }

    /**
     * 添加底部View
     */
    fun addFooterView(view: View){
        val position = mFooterViews.indexOfValue(view)
        if (position < 0){
            mFooterViews.put(BASE_ITEM_TYPE_FOOTER++, view)
        }
        notifyDataSetChanged()
    }

    /**
     * 移除底部View
     */
    fun removeFooterView(view: View){
        val index = mFooterViews.indexOfValue(view)
        if (index > 0){
            mFooterViews.removeAt(index)
            notifyDataSetChanged()
        }
    }

    /**
     * 解决GridLayoutManager添加头部和底部不占用一行的问题
     */
    public fun adjustSpanSize(recyclerView: RecyclerView){
        if (recyclerView.layoutManager is GridLayoutManager){
            val layoutManager = recyclerView.layoutManager as GridLayoutManager
            layoutManager.spanSizeLookup = object : SpanSizeLookup(){
                override fun getSpanSize(position: Int): Int {
                    val isHeaderOrFooter = isHeaderPosition(position) || isFooterPosition(position)
                    return if (isHeaderOrFooter) layoutManager.spanCount else 1
                }
            }
        }
    }

    companion object {
        var BASE_ITEM_TYPE_HEADER = 100000
        var BASE_ITEM_TYPE_FOOTER = 200000
        const val TAG = "WrapRecyclerAdapter"
    }

}