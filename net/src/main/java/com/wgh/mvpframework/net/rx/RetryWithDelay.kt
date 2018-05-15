package com.wgh.mvpframework.net.rx

import io.reactivex.Observable
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit

/**
 * Create by wgh on 2018/5/15.
 * Description: 重试设置
 */
class RetryWithDelay constructor(private val maxRetryCount: Int = MAX_RETRY_COUNT,
                                 private val delay: Int = DELAY)
    : Function<Observable<out Throwable>, Observable<*>>{

    private var retryCount: Int = 0

    init {
        this.retryCount = 0
    }

    override fun apply(attempts: Observable<out Throwable>): Observable<*> {
        return attempts
                .flatMap { throwable ->
                    if (++retryCount <= maxRetryCount){
                        Observable.timer(delay.toLong(), TimeUnit.MILLISECONDS)
                    } else {
                        Observable.error(throwable)
                    }
                }
    }

    companion object {
        private const val MAX_RETRY_COUNT = 3
        private const val DELAY = 3000
    }

}