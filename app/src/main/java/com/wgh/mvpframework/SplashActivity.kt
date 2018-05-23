package com.wgh.mvpframework

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.wgh.mvpframework.common.base.BaseActivity
import com.wgh.mvpframework.common.WccLogger
import com.wgh.mvpframework.common.arouter.RouterUtils
import es.dmoral.toasty.Toasty

class SplashActivity : BaseActivity() {

    companion object {
        const val TAG = "SplashActivity"
        const val REQUEST_CODE_LOGIN = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//        ARouter.getInstance().build(RouterUtils.ModulePublic.ROUTER_PUBLIC_LOGIN).navigation(this@SplashActivity, SplashActivity.REQUEST_CODE_LOGIN)
        ARouter.getInstance().build(RouterUtils.ModuleTest.ROUTER_TEST_MAIN).navigation(this@SplashActivity, SplashActivity.REQUEST_CODE_LOGIN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        WccLogger.d(TAG, "$requestCode ... ${data!!.extras.getString("loginResult")}" )
        when (requestCode) {
            SplashActivity.REQUEST_CODE_LOGIN ->
                when(data.getStringExtra("loginResult")) {
                    "Success" ->{
                        Toasty.success(this@SplashActivity, "登录成功", Toast.LENGTH_SHORT).show()
                        ARouter.getInstance().build(RouterUtils.ModuleTest.ROUTER_TEST_MAIN).navigation(this@SplashActivity)
                    }

                }
        }
    }
}
