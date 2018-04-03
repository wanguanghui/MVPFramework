package com.wgh.mvpframework.network

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * @version V0.1.0
 * @author: wgh
 * @date: 2018/4/3
 * @description
 */
class OkHttpUtils private constructor() {
    private val mOkHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(OkHttpInterceptor())
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

    companion object {

        private val TAG = "OkHttpUtils"

        private var mInstance: OkHttpUtils? = null
        private val scalarsConverterFactory = ScalarsConverterFactory.create()
        private val gsonConverterFactory = GsonConverterFactory.create()
        private val rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create()

        val instance: OkHttpUtils
            @Synchronized get() {
                if (mInstance == null) {
                    mInstance = OkHttpUtils()
                }
                return mInstance!!
            }
    }

}
