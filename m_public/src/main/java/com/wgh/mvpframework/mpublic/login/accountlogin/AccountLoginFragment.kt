package com.wgh.mvpframework.mpublic.login.accountlogin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wgh.mvpframework.common.net.model.LoginModel
import com.wgh.mvpframework.common.net.model.TestBean
import com.wgh.mvpframework.mpublic.R
import com.wgh.mvpframework.common.base.BaseFragment
import com.wgh.mvpframework.common.utils.WccLogger
import kotlinx.android.synthetic.main.fragment_account_login.*

/**
 * Create by wgh on 2018/5/16.
 * Description:
 */
class AccountLoginFragment : BaseFragment(), AccountLoginContract.View{

    companion object {
        const val TAG = "AccountLoginFragment"
    }

    lateinit var mPresenter :AccountLoginContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_account_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter = AccountLoginPresenter()
        mPresenter.attachView(this)
        initListener()
    }

    private fun initListener() {

        btn_sign_in.setOnClickListener { mPresenter.login(LoginModel(et_account.text.toString(), et_password.text.toString())) }

    }

    override fun loginSuccess(info: TestBean) {
        WccLogger.d(TAG, "loginSuccess")
        val intent = Intent()
        intent.putExtra("loginResult", "Success")
        activity!!.setResult(1, intent)
        activity!!.finish()

    }

    override fun loginFailed(throwable: Throwable) {
    }

    override fun showLoading() {
        showLoadingDialog()
    }

    override fun hideLoading() {
        hideLoadingDialog()
    }

    override fun toastMsg(msg: String) {
    }
}