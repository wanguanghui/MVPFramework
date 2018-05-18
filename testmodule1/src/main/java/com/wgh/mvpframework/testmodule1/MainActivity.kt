package com.wgh.mvpframework.testmodule1

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.wgh.mvpframework.common.arouter.RouterUtils
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RouterUtils.ROUTER_TEST_MAIN)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21){
            window.statusBarColor = resources.getColor(R.color.colorAccent)
        }
        setContentView(R.layout.activity_main)

        tv_to_login.setOnClickListener(View.OnClickListener { ARouter.getInstance().build(RouterUtils.ROUTER_PUBLIC_LOGIN).navigation() })
    }
}
