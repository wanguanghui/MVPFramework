package com.wgh.mvpframework.base

import org.reactivestreams.Subscription

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
open class BasePresenter<V : IBaseView> {

    protected var mvpView : V ?= null

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
    }

    /**
     * 添加RxJava订阅关系
     */
    fun addSubscription(subscription: Subscription){

    }
}