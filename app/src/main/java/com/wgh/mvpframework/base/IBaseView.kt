package com.wgh.mvpframework.base

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
interface IBaseView {

    fun showProgress(show: Boolean)

    fun showRequestError(errno: String, msg: String)

}