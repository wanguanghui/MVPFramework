package com.wgh.mvpframework.testmodule1

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.wgh.mvpframework.common.adapter.CategoryItemDecoration
import com.wgh.mvpframework.common.arouter.RouterUtils
import com.wgh.mvpframework.common.net.bean.RvBean
import com.wgh.mvpframework.common.utils.WccGlide
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
        rv.adapter = CategoryListAdapter(list)
        val dividerItemDecoration: DividerItemDecoration = DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.shape_item_divider))
//        rv.addItemDecoration(dividerItemDecoration)
        rv.addItemDecoration(CategoryItemDecoration(resources.getDrawable(R.drawable.shape_item_divider)))
//        rv.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))


    }

    class CategoryListAdapter(val list: List<RvBean>) : RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_test, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindData(list[position], position)
        }


        class ViewHolder constructor(var view: View) : RecyclerView.ViewHolder(view) {

            fun bindData(rvBean: RvBean, position: Int){
                with(rvBean){
                    itemView.tvTest.text = text
                    WccGlide.loadImage(itemView.context, imgUrl, itemView.ivTest)
                }
            }

        }
    }

}
