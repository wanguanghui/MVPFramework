package com.wgh.mvpframework

/**
 * @author: wgh
 * @date: 2018/4/2
 * @version V0.1.0
 * @description
 */
class LoginPresenter(var loginView: ILoginView) : ILoginPresenter {

    internal var loginModel: ILoginModel = LoginModel(this)

    override fun login2Server(userName: String, password: String) {
        loginView.showProgress(true)
        loginModel.login(userName, password)
    }

    override fun loginSuccess() {
        loginView.showProgress(false)
        loginView.showLoginView()
    }
}