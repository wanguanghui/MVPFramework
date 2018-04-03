package com.wgh.mvpframework.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewId())
        registerListener()
        initData()
    }

    protected abstract fun getContentViewId(): Int

    protected abstract fun registerListener()

    protected abstract fun initData()

    /**
     * Activity跳转
     * bundle: 参数，无参可不传
     */
    protected inline fun <reified A : Activity> Activity.navigate(bundle: Bundle ?= null){
        val intent = Intent(this, A::class.java)
        bundle ?.let { intent.putExtras(it) }
        startActivity(intent)
    }
}