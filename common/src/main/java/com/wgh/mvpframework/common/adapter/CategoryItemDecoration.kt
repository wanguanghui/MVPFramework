package com.wgh.mvpframework.common.adapter

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Create by wgh on 2018/5/23.
 * Description:
 */
class CategoryItemDecoration constructor(val mDivider : Drawable): RecyclerView.ItemDecoration() {

    override fun onDraw(c: Canvas?, parent: RecyclerView, state: RecyclerView.State?) {
        val childCount = parent.childCount
        var rect = Rect()
        rect.left = parent.paddingLeft
        rect.right = parent.width - parent.paddingRight
        for(i in 1..childCount){
            var childView = parent.getChildAt(i-1)
            rect.top = childView.bottom
            rect.bottom = rect.top + mDivider.intrinsicHeight
            mDivider.setBounds(rect.left, rect.top, rect.right, rect.bottom)
            mDivider.draw(c)
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        outRect.bottom += mDivider.intrinsicHeight
    }

}