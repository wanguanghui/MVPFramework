package com.wgh.mvpframework.mpublic.login.accountlogin

import com.wgh.mvpframework.common.net.model.LoginModel
import com.wgh.mvpframework.common.net.model.TestBean
import com.wgh.mvpframework.mpublic.base.BasePresenter
import com.wgh.mvpframework.mpublic.base.BaseView

/**
 * Create by wgh on 2018/5/16.
 * Description:
 */
interface AccountLoginContract {

    interface View : BaseView {

        /** 登陆成功 */
        fun loginSuccess(info: TestBean)

        /**
         * 登录失败
         */
        fun loginFailed(throwable: Throwable)

    }

    interface Presenter : BasePresenter<View>{
        fun login(loginModel: LoginModel)
    }

}