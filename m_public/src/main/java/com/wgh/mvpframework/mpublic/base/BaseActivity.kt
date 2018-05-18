package com.wgh.mvpframework.mpublic.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.wgh.mvpframework.common.dialog.LoadingDialog

/**
 * Create by wgh on 2018/5/16.
 * Description:
 */
abstract class BaseActivity : AppCompatActivity() {

    val loadingDialog: LoadingDialog by lazy {
        LoadingDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun hideLoadingDialog(){
        if (loadingDialog.isShowing){
            loadingDialog.dismiss()
        }
    }

    fun showLoadingDialog(msg: String? = null){
        if (!loadingDialog.isShowing){
            loadingDialog.show()
            if (!msg.isNullOrEmpty()){
                loadingDialog.setMsg(msg!!)
            }
        }
    }

    override fun onDestroy() {
        if (loadingDialog.isShowing){
            loadingDialog.dismiss()
        }
        super.onDestroy()
    }
}
