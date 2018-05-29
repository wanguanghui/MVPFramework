package com.wgh.mvpframework.common.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Create by wgh on 2018/5/25.
 * Description:
 */
public class WccToast {

    private static Toast mToast = null;

    private WccToast() {
    }

    public static void toastShort(Context context, CharSequence msg){
        if (mToast == null){
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    public static void toastShort(Context context, @StringRes int resId){
        if (mToast == null){
            mToast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(resId);
        }
        mToast.show();
    }

    public static void toastLong(Context context, CharSequence msg){
        if (mToast == null){
            mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    public static void toastLong(Context context, @StringRes int resId){
        if (mToast == null){
            mToast = Toast.makeText(context, resId, Toast.LENGTH_LONG);
        } else {
            mToast.setText(resId);
        }
        mToast.show();
    }

}
