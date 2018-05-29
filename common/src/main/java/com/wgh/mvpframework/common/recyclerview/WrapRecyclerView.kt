package com.wgh.mvpframework.common.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import com.wgh.mvpframework.common.recyclerview.adapter.CommonListAdapter
import com.wgh.mvpframework.common.recyclerview.adapter.WrapRecyclerAdapter

/**
 * Create by wgh on 2018/5/29.
 * Description:
 */
class WrapRecyclerView : RecyclerView {


    private var mWrapRecyclerAdapter: WrapRecyclerAdapter? = null

    private var mAdapter: Adapter<*>? = null
    private lateinit var mContext: Context

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle){
        mContext = context
    }

    override fun setAdapter(adapter: Adapter<ViewHolder>) {
        if (mAdapter != null){
            mAdapter!!.unregisterAdapterDataObserver(mDataObserver)
            mAdapter = null
        }
        this.mAdapter = adapter
        when(adapter){
            is WrapRecyclerAdapter -> mWrapRecyclerAdapter = adapter
            else -> mWrapRecyclerAdapter = WrapRecyclerAdapter(adapter)
        }
        super.setAdapter(mWrapRecyclerAdapter)
        mAdapter!!.registerAdapterDataObserver(mDataObserver)
        mWrapRecyclerAdapter!!.adjustSpanSize(this)
    }

    /**
     * 添加头部View
     */
    fun addHeaderView(view: View){
        if (mWrapRecyclerAdapter != null){
            mWrapRecyclerAdapter!!.addHeaderView(view)
        }
    }

    /**
     * 移除头部View
     */
    fun removeHeaderView(view: View){
        if (mWrapRecyclerAdapter != null){
            mWrapRecyclerAdapter!!.removeHeaderView(view)
        }
    }

    /**
     * 添加底部View
     */
    fun addFooterView(view: View){
        if (mWrapRecyclerAdapter != null){
            mWrapRecyclerAdapter!!.addFooterView(view)
        }
    }

    /**
     * 移除底部View
     */
    fun removeFooterView(view: View){
        if (mWrapRecyclerAdapter != null){
            mWrapRecyclerAdapter!!.addFooterView(view)
        }
    }

    private var mDataObserver = object : AdapterDataObserver() {

        override fun onChanged() {
            if (mAdapter == null) return
            if (mWrapRecyclerAdapter != mAdapter){
                mWrapRecyclerAdapter!!.notifyDataSetChanged()
            }
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            if (mAdapter == null) return
            if (mWrapRecyclerAdapter != mAdapter){
                mWrapRecyclerAdapter!!.notifyItemRemoved(positionStart)
            }
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
            if (mAdapter == null) return
            if (mWrapRecyclerAdapter != mAdapter){
                mWrapRecyclerAdapter!!.notifyItemMoved(fromPosition, toPosition)
            }
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            if (mAdapter == null) return
            if (mWrapRecyclerAdapter != mAdapter){
                mWrapRecyclerAdapter!!.notifyItemInserted(positionStart)
            }
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
            if (mAdapter == null) return
            if (mWrapRecyclerAdapter != mAdapter){
                mWrapRecyclerAdapter!!.notifyItemChanged(positionStart, payload)
            }
        }
    }
}