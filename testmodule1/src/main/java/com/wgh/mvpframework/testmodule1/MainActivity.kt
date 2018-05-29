package com.wgh.mvpframework.testmodule1

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.wgh.mvpframework.common.recyclerview.decoration.CategoryItemDecoration
import com.wgh.mvpframework.common.recyclerview.adapter.CommonListAdapter
import com.wgh.mvpframework.common.recyclerview.adapter.MultiTypeSupport
import com.wgh.mvpframework.common.arouter.RouterUtils
import com.wgh.mvpframework.common.net.bean.RvBean
import com.wgh.mvpframework.common.recyclerview.adapter.WrapRecyclerAdapter
import com.wgh.mvpframework.common.utils.WccGlide
import com.wgh.mvpframework.common.utils.WccToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_rv_test.view.*


@Route(path = RouterUtils.ModuleTest.ROUTER_TEST_MAIN)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21){
            window.statusBarColor = resources.getColor(R.color.colorAccent)
        }
        setContentView(R.layout.activity_main)
        val linearLayoutManager = LinearLayoutManager(this@MainActivity)
        rv.layoutManager = linearLayoutManager
        val list: MutableList<RvBean> = ArrayList()
        for (i in 1 ..50){
            list.add(RvBean("测试文本 -- ${i}", "http://www.biaobaiju.com/uploads/20180111/02/1515607460-UShmBCfKWP.jpg"))
        }
        val multiTypeSupport = object: MultiTypeSupport<RvBean> {
            override fun getLayoutId(item: RvBean, position: Int): Int {
                return if(position % 2 == 0) R.layout.item_rv_test else R.layout.item_rv_test_h
            }
        }
        val adapter = object: CommonListAdapter<RvBean>(list, multiTypeSupport){
            override fun bindData(holder: RecyclerView.ViewHolder, item: RvBean, position: Int) {
                with(item){
                    holder.itemView.tvTest.text = text
                    WccGlide.loadImage(holder.itemView.context, imgUrl, holder.itemView.ivTest)
                }
                holder.itemView.setOnClickListener { WccToast.toastShort(this@MainActivity, "$position") }
            }
        }
//        adapter.setItemClickListener(object : CommonListAdapter.OnItemClickListener{
//            override fun onItemClick(position: Int) {
//                WccToast.toastShort(this@MainActivity, "$position")
//            }
//
//        })

        val headerFooterAdapter = WrapRecyclerAdapter(adapter)
//        rv.adapter = headerFooterAdapter
        rv.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.shape_item_divider))
        rv.addItemDecoration(CategoryItemDecoration(resources.getDrawable(R.drawable.shape_item_divider)))
        rv.addHeaderView(View.inflate(this@MainActivity, R.layout.view_header, null))
    }

}
