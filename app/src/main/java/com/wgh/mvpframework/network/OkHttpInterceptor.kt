package com.wgh.mvpframework.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
class OkHttpInterceptor : Interceptor{

    companion object {
        private val TAG = "OkHttpInterceptor"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val requesetBuilder = request.newBuilder()

        val headers = request.headers()

        val requsetUrl = request.url().toString()
        val methpdStr = request.method()
        val body = request.body()
        val bodyStr = body?.toString() ?: ""

        val httpUrlBuilder = request.url().newBuilder()
        httpUrlBuilder.addQueryParameter("udid", "aaa")
        requesetBuilder.url(httpUrlBuilder.build())

        request = requesetBuilder.build()
        return chain.proceed(request)


    }
}