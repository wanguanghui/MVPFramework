package com.wgh.mvpframework

import com.wgh.mvpframework.R.id.password
import com.wgh.mvpframework.base.BasePresenter
import com.wgh.mvpframework.bean.DouBanMovieTop250
import com.wgh.mvpframework.bean.TestBean
import com.wgh.mvpframework.net.api.TestApi
import com.wgh.mvpframework.net.core.MyRetrofit
import com.wgh.mvpframework.network.OkHttpUtil
import com.wgh.mvpframework.network.OkHttpUtils
import com.wgh.mvpframework.utils.utils.WccLogger
import io.reactivex.*
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
        val map : Map<String, String> = mapOf(Pair("username", userName), Pair("pwd", password))
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
                        com.wgh.mvpframework.utils.utils.WccLogger.d(TAG, s.toString())
                    }

                    override fun onError(e: Throwable) {
                        com.wgh.mvpframework.utils.utils.WccLogger.d(TAG, "onError")
                        e.printStackTrace()
                    }

                    override fun onComplete() {
                        com.wgh.mvpframework.utils.utils.WccLogger.d(TAG, "onComplete")
                        loginSuccess()
                    }

                })


    }

    fun test(index: String) {
        mvpView!!.showProgress(true)
        val map : Map<String, String> = mapOf(Pair("start", index))
        MyRetrofit.getClient().create(TestApi::class.java)
//                .testApi
                .testGet("aaa", "123456")
//                .testPost("aaa", "123456")
//                .testPost(TestModel("aaa", "123456"))
//        OkHttpUtils.instance
//                .getTestApi()!!
//                .test(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {  }
                .doOnError {  }
                .doFinally {
                    WccLogger.d(TAG, "onComplete")
                    loginSuccess() }
                .subscribe({ WccLogger.d(TAG, it.toString()) },
                        {
                            it.printStackTrace()
                        })



//        Observable.create(ObservableOnSubscribe { emitter: ObservableEmitter<String> ->
//            emitter.onNext("hello")
//            emitter.onNext("world")
//            emitter.onComplete()
//        })
//                .map()
//                .subscribeOn()
//                .subscribe()


    }

    override fun loginSuccess() {
        mvpView!!.showProgress(false)
        mvpView!!.showLoginView()
    }
}


