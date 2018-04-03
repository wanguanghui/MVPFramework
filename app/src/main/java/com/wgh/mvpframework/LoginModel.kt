package com.wgh.mvpframework

import android.os.Handler
import android.util.Log
import com.wgh.mvpframework.network.OkHttpUtils


/**
 * @author: wgh
 * @date: 2018/4/2
 * @version V0.1.0
 * @description
 */
class LoginModel(var presenter: ILoginPresenter) : ILoginModel {

    private val mHandler = Handler()

    override fun login(name: String, password: String) {
        mHandler.postDelayed({
            Log.d("LoginModel", "run:")
            presenter.loginSuccess()
        }, 2000)

    }


}