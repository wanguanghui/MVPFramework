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
class ResponseInterceptor : Interceptor{

    companion object {
        private val TAG = "RequestInterceptor"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val response = chain.proceed(request)
        val responseBody = response.peekBody(response.body()!!.contentLength())

        WccLogger.d(TAG, "requestUrl: " + response.request().url())
        WccLogger.json(TAG, responseBody.string())

        return response


    }
}