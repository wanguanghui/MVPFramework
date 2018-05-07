package com.wgh.mvpframework.base

import android.os.Bundle
import android.view.View

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
abstract class BaseMvpFragment<P : BasePresenter<*>> : BaseFragment() {

    var mvpPresenter : P ?= null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mvpPresenter = createPresenter()
    }

    abstract fun createPresenter(): P

    override fun onDestroy() {
        super.onDestroy()
        if (mvpPresenter != null){
            mvpPresenter!!.detachView()
        }
    }

}