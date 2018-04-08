package com.wgh.mvpframework

import com.wgh.mvpframework.R.id.password
import com.wgh.mvpframework.base.BasePresenter
import com.wgh.mvpframework.bean.DouBanMovieTop250
import com.wgh.mvpframework.network.OkHttpUtils
import com.wgh.mvpframework.network.model.DouBanTestModel
import com.wgh.mvpframework.utils.WccLogger
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author: wgh
 * @date: 2018/4/2
 * @version V0.1.0
 * @description
 */
class LoginPresenter : BasePresenter<ILoginView>(), ILoginPresenter {

    companion object {
        val TAG = "LoginPresenter"
    }

    private var loginModel: ILoginModel = LoginModel(this)

    override fun login2Server(userName: String, password: String) {
        mvpView!!.showProgress(true)
//        loginModel.login(userName, password)
        val map : Map<String, String> = mapOf(Pair("username", userName), Pair("password", password))
//        Test.login(userName, password)
        OkHttpUtils.instance
                .getTestApi()!!
                .test(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<DouBanMovieTop250> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(s: DouBanMovieTop250) {
                        WccLogger.d(TAG, s.toString())
                    }

                    override fun onError(e: Throwable) {
                        WccLogger.d(TAG, "onError")
                        e.printStackTrace()
                    }

                    override fun onComplete() {
                        WccLogger.d(TAG, "onComplete")
                        loginSuccess()
                    }

                })


    }

    fun test(index: String) {
        mvpView!!.showProgress(true)
//        loginModel.login(userName, password)
        val map : Map<String, String> = mapOf(Pair("start", index))
//        Test.login(userName, password)
        OkHttpUtils.instance
                .getTestApi()!!
                .test(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<DouBanMovieTop250> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(s: DouBanMovieTop250) {
                        WccLogger.d(TAG, s.toString())
                    }

                    override fun onError(e: Throwable) {
                        WccLogger.d(TAG, "onError")
                        e.printStackTrace()
                    }

                    override fun onComplete() {
                        WccLogger.d(TAG, "onComplete")
                        loginSuccess()
                    }

                })


    }

    override fun loginSuccess() {
        mvpView!!.showProgress(false)
        mvpView!!.showLoginView()
    }
}


