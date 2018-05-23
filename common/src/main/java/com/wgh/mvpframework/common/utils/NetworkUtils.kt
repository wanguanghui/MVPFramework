package com.wgh.mvpframework.common.utils

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.provider.Settings

/**
 * Create by wgh on 2018/5/18.
 * Description:
 */
class NetworkUtils {

    companion object {

        /**
         * 打开网络设置
         */
        fun openWirelessSettings(context: Application){
            context.startActivity(Intent(Settings.ACTION_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        }

        /**
         * 获取活动网络信息
         */
        fun getActiveNetworkInfo(context: Application): NetworkInfo =
                (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo

        /**
         * 判断网络是否连接
         */
        fun isConnected(context: Application): Boolean = getActiveNetworkInfo(context).isConnected

//        fun

    }

    interface NetworkType {

    }

}