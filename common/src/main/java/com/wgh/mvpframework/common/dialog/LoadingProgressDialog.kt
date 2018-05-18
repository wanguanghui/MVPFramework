package com.wgh.mvpframework.common.dialog

import android.app.Dialog
import android.content.Context
import com.wgh.mvpframework.common.R
import kotlinx.android.synthetic.main.layout_dialog_loading.*

/**
 * Create by wgh on 2018/5/16.
 * Description: LoadingDialog
 */
class LoadingDialog constructor(context: Context, themeResId: Int = R.style.loading_dialog): Dialog(context, themeResId) {

    init {
        init(context)
    }

    private fun init(context: Context) {
        setContentView(R.layout.layout_dialog_loading)
        setCanceledOnTouchOutside(false)
    }

    fun setMsg(msg: String){
        tv_msg.text = msg
    }

    override fun show() {
        super.show()
        setMsg(context.getString(R.string.loading))
    }

}