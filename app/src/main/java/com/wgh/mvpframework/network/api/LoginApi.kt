package com.wgh.mvpframework.network.api

import com.wgh.mvpframework.base.BaseBean
import com.wgh.mvpframework.bean.DouBanMovieTop250
import com.wgh.mvpframework.network.model.DouBanTestModel
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
interface LoginApi {

    @GET("/v2/movie/top250")
    fun test(@QueryMap options: Map<String, String>) : Observable<DouBanMovieTop250>

    @GET("/v2/movie/top250")
    fun test(@Body option: DouBanTestModel) : Observable<DouBanMovieTop250>

    @POST("post")
    fun <T : BaseBean> test(@Body bean: Class<T>) : Observable<String>

}