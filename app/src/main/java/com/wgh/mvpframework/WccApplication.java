package com.wgh.mvpframework;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wgh.mvpframework.net.core.MyRetrofit;
import com.wgh.mvpframework.utils.WccLogger;
import com.wgh.mvpframework.utils.constant.CommonConstant;

/**
 * @version V0.1.0
 * @author: wgh
 * @date: 2018/4/4
 * @description
 */
public class WccApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        WccLogger.initLogger();
        if (CommonConstant.INSTANCE.getDEBUG()){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        MyRetrofit.Companion.initClient(this);
    }
}
