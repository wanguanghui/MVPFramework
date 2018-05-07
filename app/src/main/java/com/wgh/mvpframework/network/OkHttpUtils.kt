package com.wgh.mvpframework.network

import com.wgh.mvpframework.network.api.LoginApi
import com.wgh.mvpframework.net.interceptor.RequestInterceptor
import com.wgh.mvpframework.net.interceptor.ResponseInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * @version V0.1.0
 * @author: wgh
 * @date: 2018/4/3
 * @description
 */
class OkHttpUtils private constructor() {
    private val mOkHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(RequestInterceptor())
            .addInterceptor(ResponseInterceptor())
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()



    companion object {

        val TAG = "OkHttpUtils"

        private var mInstance: OkHttpUtils? = null
        private val gsonConverterFactory = GsonConverterFactory.create()
        private val rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create()
        private var testApi : LoginApi ?= null

        public val instance: OkHttpUtils
            @Synchronized public get() {
                if (mInstance == null) {
                    mInstance = OkHttpUtils()
                }
                return mInstance!!
            }
    }

    fun getTestApi() : LoginApi? {
        if (testApi == null){
            var retrofit = Retrofit.Builder()
                    .client(mOkHttpClient)
                    .baseUrl(Urls.baseUrl)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build()
            testApi = retrofit.create(LoginApi::class.java)
        }
        return testApi
    }

}
