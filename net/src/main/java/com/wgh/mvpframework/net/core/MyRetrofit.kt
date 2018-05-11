package com.wgh.mvpframework.net.core

import android.app.Application
import com.wgh.mvpframework.net.interceptor.RequestInterceptor
import com.wgh.mvpframework.net.interceptor.ResponseInterceptor
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author: wgh
 * @date: 2018/5/7
 * @version V0.1.0
 * @description
 */
class MyRetrofit {

    companion object {
        private var retrofitClient: Retrofit? = null
        private var httpClient: OkHttpClient? = null

        fun initClient(context: Application) {
            retrofitClient = createRetrofit(context)
        }

        fun getClient(): Retrofit {
            if (retrofitClient == null){
                throw NullPointerException("请现在Application中initClient()")
            } else {
                return retrofitClient!!
            }
        }

        private fun createRetrofit(context: Application): Retrofit {
            httpClient = OkHttpClient()
                    .newBuilder()
                    .addInterceptor(RequestInterceptor())
                    .addInterceptor(ResponseInterceptor())
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            return Retrofit.Builder()
                    .client(httpClient)
                    .baseUrl(NetConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
    }

}