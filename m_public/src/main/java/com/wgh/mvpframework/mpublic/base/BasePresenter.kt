package com.wgh.mvpframework.mpublic.base

/**
 * Create by wgh on 2018/5/16.
 * Description:persenter基础接口
 */
interface BasePresenter<T : BaseView> {

    fun attachView(view : T)

    fun onStart()

    fun onStop()

}