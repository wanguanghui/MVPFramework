package com.wgh.mvpframework

/**
 * @author: wgh
 * @date: 2018/4/2
 * @version V0.1.0
 * @description
 */
interface ILoginPresenter {

    fun login2Server(userName: String, password: String)

    fun loginSuccess()

}