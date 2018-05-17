package com.wgh.mvpframework.net.rx

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create by wgh on 2018/5/15.
 * Description:
 */
object RxUtil {

    fun <T> io_main(): ObservableTransformer<T, T>{
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

}