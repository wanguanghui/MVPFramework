package com.wgh.mvpframework.base

import android.os.Bundle

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
abstract class BaseMvpActivity<P : BasePresenter<*>> : BaseActivity() {

    var mvpPresenter : P ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        mvpPresenter = createPresenter()
        acctchView()
        super.onCreate(savedInstanceState)
    }

    protected abstract fun acctchView()

    abstract fun createPresenter(): P

    override fun onDestroy() {
        super.onDestroy()
        if (mvpPresenter != null){
            mvpPresenter!!.detachView()
        }
    }

}