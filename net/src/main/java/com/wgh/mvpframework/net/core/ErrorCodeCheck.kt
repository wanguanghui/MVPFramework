package com.wgh.mvpframework.net.core

/**
 * Create by wgh on 2018/5/15.
 * Description:
 */
object ErrorCodeCheck {

    fun success(errno: Int): Boolean = errno == HttpStatusCode.SUCCESS || errno == 200

}