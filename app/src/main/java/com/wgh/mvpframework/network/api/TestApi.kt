package com.wgh.mvpframework.network.api

import com.wgh.mvpframework.base.BaseBean
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.QueryMap

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
interface TestApi {

    @POST("post")
    fun test(@QueryMap options: Map<String, String>) : Observable<String>

    @POST("post")
    fun <T : BaseBean> test(@Body bean: Class<T>) : Observable<String>

}