package com.wgh.mvpframework.base

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
open class BasePresenter<V : IBaseView> {

    protected var mvpView : V ?= null
    protected var mCompositeSubscription : CompositeSubscription ?= null

    fun attachView(mvpView: V){
        this.mvpView = mvpView
    }

    fun detachView(){
        this.mvpView = null
        onUnSubscribe()
    }

    /**
     * 取消RxJava订阅关系
     */
    private fun onUnSubscribe(){
        mCompositeSubscription!!.unsubscribe()
    }

    /**
     * 添加RxJava订阅关系
     */
    fun addSubscription(subscription: Subscription){
        if (mCompositeSubscription == null){
            mCompositeSubscription = CompositeSubscription()
        }
        mCompositeSubscription!!.add(subscription)

    }
}