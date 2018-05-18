package com.wgh.mvpframework.mpublic.login
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.alibaba.android.arouter.facade.annotation.Route
import com.wgh.mvpframework.mpublic.R
import com.wgh.mvpframework.mpublic.base.BaseActivity
import com.wgh.mvpframework.mpublic.login.accountlogin.AccountLoginFragment
import com.wgh.mvpframework.common.arouter.RouterUtils


@Route(path = RouterUtils.ROUTER_PUBLIC_LOGIN)
class LoginActivity : BaseActivity() {

    private lateinit var accountLoginFragment: AccountLoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initFragments()
        initView()
    }

    private fun initFragments() {

        accountLoginFragment = AccountLoginFragment()

    }

    private fun initView() {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fl_login_content, accountLoginFragment)
        fragmentTransaction.commitAllowingStateLoss()
    }

}

