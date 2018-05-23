package com.wgh.mvpframework.testmodule1;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Create by wgh on 2018/5/23.
 * Description:
 */
public class TestLinearLayout2 extends LinearLayout {
    public TestLinearLayout2(Context context) {
        this(context, null);
    }

    public TestLinearLayout2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestLinearLayout2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_test2, this);
//        setClipChildren(false);
    }

}
