package com.wgh.mvpframework.mpublic.base

/**
 * Create by wgh on 2018/5/16.
 * Description:View层通用抽象接口
 */
interface BaseView {

    /** 显示loading */
    fun showLoading()

    /** 隐藏loading */
    fun hideLoading()

    fun toastMsg(msg: String)

}