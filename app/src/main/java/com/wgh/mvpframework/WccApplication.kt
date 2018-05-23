package com.wgh.mvpframework

import android.app.Application

import com.alibaba.android.arouter.launcher.ARouter
import com.wgh.mvpframework.common.WccLogger
import com.wgh.mvpframework.common.constant.CommonConstant
import com.wgh.mvpframework.common.net.core.WccRetrofit

/**
 * @version V0.1.0
 * @author: wgh
 * @date: 2018/4/4
 * @description
 */
class WccApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        WccLogger.initLogger()

        if (CommonConstant.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)

        WccRetrofit.initClient(this)
    }

    companion object {
        lateinit var instance: Application
            private set
    }

}
