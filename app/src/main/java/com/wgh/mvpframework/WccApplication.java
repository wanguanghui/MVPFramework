package com.wgh.mvpframework;

import android.app.Application;

import com.wgh.mvpframework.utils.WccLogger;

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
    }
}
