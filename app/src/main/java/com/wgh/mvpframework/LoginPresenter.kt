package com.wgh.mvpframework

import com.wgh.mvpframework.base.BasePresenter

/**
 * @author: wgh
 * @date: 2018/4/2
 * @version V0.1.0
 * @description
 */
class LoginPresenter : BasePresenter<ILoginView>(), ILoginPresenter {

    private var loginModel: ILoginModel = LoginModel(this)

    override fun login2Server(userName: String, password: String) {
        mvpView!!.showProgress(true)
        loginModel.login(userName, password)
    }

    override fun loginSuccess() {
        mvpView!!.showProgress(false)
        mvpView!!.showLoginView()
    }
}