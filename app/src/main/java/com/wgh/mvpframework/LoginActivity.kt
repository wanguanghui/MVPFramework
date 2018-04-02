package com.wgh.mvpframework

import android.content.Context
import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), ILoginView {

    var mContext: Context = this
    var loginPresenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_sign_in_button.setOnClickListener{
            loginPresenter.login2Server("", "")
        }

    }

    override fun showProgress(enable: Boolean) {
        if (enable){
            login_progress.visibility = View.VISIBLE
        } else{
            login_progress.visibility = View.GONE
        }
    }

    override fun showLoginView() {
        Toast.makeText(mContext, "登陆成功", Toast.LENGTH_SHORT).show()
    }
}

