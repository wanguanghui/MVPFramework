package com.wgh.mvpframework.base

import android.os.Build
import android.os.Bundle
import com.wgh.mvpframework.R

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
//        if (Build.VERSION.SDK_INT >= 21){
//            window.statusBarColor = resources.getColor(R.color.colorAccent)
//        }
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