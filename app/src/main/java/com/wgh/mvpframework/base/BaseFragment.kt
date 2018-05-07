package com.wgh.mvpframework.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author: wgh
 * @date: 2018/4/3
 * @version V0.1.0
 * @description
 */
abstract class BaseFragment : Fragment() {

    lateinit var mContext: Activity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getContentViewId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mContext = this.activity!!

        registerListener()

        initData()
    }

    protected abstract fun getContentViewId(): Int

    protected abstract fun registerListener()

    protected abstract fun initData()

    protected inline fun  <reified A : Activity> Fragment.navigate(bundle: Bundle ?= null){
        val intent = Intent(activity, A::class.java)
        bundle ?.let { intent.putExtras(it) }
        startActivity(intent)
    }


}