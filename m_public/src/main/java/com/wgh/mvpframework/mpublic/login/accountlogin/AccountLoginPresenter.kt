package com.wgh.mvpframework.mpublic.login.accountlogin

import com.wgh.mvpframework.mpublic.base.DefaultPresenterImpl
import com.wgh.mvpframework.net.api.LoginApi
import com.wgh.mvpframework.net.core.WccRetrofit
import com.wgh.mvpframework.net.model.LoginModel
import com.wgh.mvpframework.net.model.TestBean
import com.wgh.mvpframework.net.rx.RxUtil
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Create by wgh on 2018/5/16.
 * Description:
 */
class AccountLoginPresenter : DefaultPresenterImpl<AccountLoginContract.View>(), AccountLoginContract.Presenter{

    override fun onStart() {

    }

    override fun login(loginModel: LoginModel) {
        WccRetrofit.getClient().create(LoginApi::class.java)
                .testGet(loginModel.account, loginModel.password)
                .compose(RxUtil.io_main())
                .subscribe(object : Observer<TestBean>{
                    override fun onSubscribe(d: Disposable) {
                        compositeDisposable.add(d)
                        mWeakView.get()!!.showLoading()
                    }

                    override fun onNext(t: TestBean) {
                        mWeakView.get()!!.loginSuccess(t)
                    }

                    override fun onError(e: Throwable) {
                        mWeakView.get()!!.hideLoading()
                        mWeakView.get()!!.loginFailed(e)
                    }

                    override fun onComplete() {
                        mWeakView.get()!!.hideLoading()
                    }
                })
    }
}