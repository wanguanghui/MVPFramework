package com.wgh.mvpframework.base

import retrofit2.http.GET

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
interface IBaseModel {

    fun sendRequest2server()

    fun setApiInterface(apiInterface: String)

    fun setMethod(method: String = "GET")

    fun cancelRequest()

}