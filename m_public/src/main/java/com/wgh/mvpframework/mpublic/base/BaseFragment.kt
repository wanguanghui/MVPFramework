package com.wgh.mvpframework.mpublic.base

import android.support.v4.app.Fragment
import com.wgh.mvpframework.utils.LoadingDialog

/**
 * Create by wgh on 2018/5/16.
 * Description:
 */
open class BaseFragment : Fragment(){

    val loadingDialog: LoadingDialog by lazy {
        LoadingDialog(this.activity!!)
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