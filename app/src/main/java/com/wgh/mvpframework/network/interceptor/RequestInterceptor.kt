package com.wgh.mvpframework.network.interceptor

import com.wgh.mvpframework.utils.WccLogger
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
class RequestInterceptor : Interceptor{

    companion object {
        private val TAG = "RequestInterceptor"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var oldRequeset = chain.request()
        val requesetBuilder = oldRequeset.newBuilder()

        val headers = oldRequeset.headers()

        val httpUrlBuilder = oldRequeset.url().newBuilder()
        httpUrlBuilder.addQueryParameter("udid", "aaa")
        requesetBuilder.url(httpUrlBuilder.build())

        var newRequest = requesetBuilder.build()

        val requsetUrl = newRequest.url().toString()
        val methodStr = newRequest.method()
        val body = newRequest.body()
        val bodyStr = body?.toString() ?: ""

        WccLogger.d(TAG, methodStr + "\n" + requsetUrl + "\n" + bodyStr)

        return chain.proceed(newRequest)


    }
}