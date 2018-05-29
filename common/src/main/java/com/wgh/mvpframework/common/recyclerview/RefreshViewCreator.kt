package com.wgh.mvpframework.common.recyclerview

import android.content.Context
import android.view.View
import android.view.ViewParent

/**
 * Create by wgh on 2018/5/28.
 * Description: 下拉刷新的辅助类
 */
abstract class RefreshViewCreator {

    /**
     * 获取下拉刷新的View
     * @param parent RecyclerView
     */
    abstract fun getRefreshView(context: Context, parent: ViewParent): View

    /**
     * 正在下拉
     * @param currentDragHeight 当前拖动的高度
     * @param refreshViewHeight 总的刷新高度
     * @param currentRefreshStatus 当前状态
     */
    abstract fun onPull(currentDragHeight: Int, refreshViewHeight: Int, currentRefreshStatus: Int)

    /**
     * 正在刷新中
     */
    abstract fun onRefreshing()

    /**
     * 停止刷新
     */
    abstract fun onStopRefresh()

}