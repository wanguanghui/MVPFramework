package com.wgh.mvpframework.mpublic.base

import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * Create by wgh on 2018/5/16.
 * Description:BasePresenter的默认实现
 */
abstract class DefaultPresenterImpl<T : BaseView> : BasePresenter<T>{

    lateinit var mWeakView : WeakReference<T>
    val compositeDisposable = CompositeDisposable()

    override fun attachView(view: T) {
        mWeakView = WeakReference(view)
    }


    override fun onStop() {
        compositeDisposable.clear()
    }
}