package com.wgh.mvpframework.utils.utils;

import android.text.TextUtils;
import android.util.Log;

import com.wgh.mvpframework.utils.constant.CommonConstant;

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

    private WccLogger() {
        throw new UnsupportedOperationException("所有方法都为静态方法，不能创建对象！");
    }

    public static void initLogger(){

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

    private static void printLog(int level, String tag, String msg) {
        if (CommonConstant.INSTANCE.getDEBUG()) {
            if (TextUtils.isEmpty(tag)) {
                tag = defaultTag;
            }
            if (msg == null) {
                msg = "log == null!";
            }
//            String[] infos = getAutoJumpLogInfos();
            switch (level) {
                case LEVEL_V:
                    Log.v(tag, msg);
                    break;
                case LEVEL_D:
                    Log.d(tag, msg);
                    break;
                case LEVEL_I:
                    Log.i(tag, msg);
                    break;
                case LEVEL_W:
                    Log.w(tag, msg);
                    break;
                case LEVEL_E:
                    Log.e(tag, msg);
                    break;
                default:
                    Log.d(tag, msg);
                    break;
            }
        }
    }

    /**
     * 获取打印信息所在方法名，行号等信息
     * @return
     */
    private static String[] getAutoJumpLogInfos() {
        String[] infos = new String[] { "", "", "" };
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        if (elements.length < 5) {
            Log.e("MyLogger", "Stack is too shallow!!!");
            return infos;
        } else {
            infos[0] = elements[4].getClassName().substring(
                    elements[4].getClassName().lastIndexOf(".") + 1);
            infos[1] = elements[4].getMethodName() + "()";
            infos[2] = " at (" + elements[4].getClassName() + ".java:"
                    + elements[4].getLineNumber() + ")";
//            Log.e("abc", "0 " + infos[0]);
//            Log.e("abc", "1 " + infos[1]);
//            Log.e("abc", "2 " + infos[2]);
//                Log.e("abc", 5 + " " + elements[5].getMethodName() + "()");
            for (int i = 0; i < elements.length; i++){
                Log.e("abc", i + " " + elements[i].getMethodName() + "()");
            }
            return infos;
        }
    }
}
