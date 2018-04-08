package com.wgh.mvpframework
import android.view.View
import android.widget.Toast
import com.wgh.mvpframework.base.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseMvpActivity<LoginPresenter>(), ILoginView {


    override fun acctchView() {
        mvpPresenter!!.attachView(this)
    }

    override fun showRequestError(errno: String, msg: String) {
    }

    override fun createPresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun getContentViewId(): Int {
        return R.layout.activity_login
    }

    override fun registerListener() {
        email_sign_in_button.setOnClickListener{
//            (mvpPresenter as LoginPresenter).login2Server("", "")
            (mvpPresenter as LoginPresenter).test("25")
        }
    }

    override fun initData() {
    }

    override fun showProgress(enable: Boolean) {
        if (enable){
            login_progress.visibility = View.VISIBLE
        } else{
            login_progress.visibility = View.GONE
        }
    }

    override fun showLoginView() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show()
    }

}

