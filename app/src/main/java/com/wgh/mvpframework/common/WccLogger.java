package com.wgh.mvpframework.common;

import android.text.TextUtils;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.wgh.mvpframework.BuildConfig;

/**
 * Created by josan_tang on 7/5/16.
 * Log统一管理，只有WccConstant.DEBUG为true时，才打印log
 * 所有方法都为静态方法，不支持创建对象
 * 支持默认tag，默认tag为WccLogger
 *
 */
public class WccLogger {

    private final static String defaultTag = "WccLogger";

    private final static int LEVEL_V = 1;
    private final static int LEVEL_D = 2;
    private final static int LEVEL_I = 3;
    private final static int LEVEL_W = 4;
    private final static int LEVEL_E = 5;
    private final static int LEVEL_JSON = 6;

    private WccLogger() {
        throw new UnsupportedOperationException("所有方法都为静态方法，不能创建对象！");
    }

    public static void initLogger(){
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag("")
                .methodOffset(2)
                .showThreadInfo(false)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy){
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    public static void v(String msg) {
        v(defaultTag, msg);
    }

    public static void v(String tag, String msg) {
        printLog(LEVEL_V, tag, msg);
    }

    public static void d(String msg) {
        d(defaultTag, msg);
    }

    public static void d(String tag, String msg) {
        printLog(LEVEL_D, tag, msg);
    }

    public static void i(String msg) {
        i(defaultTag, msg);
    }

    public static void i(String tag, String msg) {
        printLog(LEVEL_I, tag, msg);
    }

    public static void w(String msg) {
        w(defaultTag, msg);
    }

    public static void w(String tag, String msg) {
        printLog(LEVEL_W, tag, msg);
    }

    public static void e(String msg) {
        e(defaultTag, msg);
    }

    public static void e(String tag, String msg) {
        printLog(LEVEL_E, tag, msg);
    }

    public static void json(String msg) {
        json(defaultTag, msg);
    }

    public static void json(String tag, String msg) {
        printLog(LEVEL_JSON, tag, msg);
    }

    private static void printLog(int level, String tag, String msg) {
        if (WccConstant.INSTANCE.getDEBUG()) {
            if (TextUtils.isEmpty(tag)) {
                tag = defaultTag;
            }
            if (msg == null) {
                msg = "log == null!";
            }
            switch (level) {
                case LEVEL_V:
                    Logger.t(tag).v(msg);
                    break;
                case LEVEL_D:
                    Logger.t(tag).d(msg);
                    break;
                case LEVEL_I:
                    Logger.t(tag).i( msg);
                    break;
                case LEVEL_W:
                    Logger.t(tag).w( msg);
                    break;
                case LEVEL_E:
                    Logger.t(tag).e( msg);
                    break;
                case LEVEL_JSON:
                    Logger.t(tag).json(msg);
                    break;
                default:
                    Logger.t(tag).e(msg);
                    break;
            }
        }
    }
}
