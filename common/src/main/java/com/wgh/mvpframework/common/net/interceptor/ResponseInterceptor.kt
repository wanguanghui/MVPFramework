package com.wgh.mvpframework.common.net.interceptor

import com.wgh.mvpframework.common.utils.WccLogger
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
        val responseBody = response.peekBody(1024*1024)

        WccLogger.d(TAG, "requestUrl: " + response.request().url())
        WccLogger.d(TAG, responseBody.string())

        return response


    }
}