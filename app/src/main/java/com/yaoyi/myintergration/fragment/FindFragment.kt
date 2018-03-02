package com.yaoyi.myintergration.fragment

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yaoyi.myintergration.Header.MaterialViewPagerHeaderDecorator
import com.yaoyi.myintergration.R
import com.yaoyi.myintergration.adapter.FindAdapter
import com.yaoyi.myintergration.mvp.contract.FindContract
import com.yaoyi.myintergration.mvp.model.bean.FindBean
import com.yaoyi.myintergration.mvp.presenter.FindPresenter
import kotlinx.android.synthetic.main.find_recycle_fragment.*

/**
 * Created by c on 2018/1/24.
 */
class FindFragment : BaseFragment(), FindContract.View , SwipeRefreshLayout.OnRefreshListener {
    /**
     * Called when a swipe gesture triggers a refresh.
     */
    override fun onRefresh() {
        refreshLayout_find.isRefreshing=false

//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */


    var mPresenter: FindPresenter? = null
    var mAdapter : FindAdapter? = null
    var mList : MutableList<FindBean>? = null
    override fun setData(beans: MutableList<FindBean>) {
        mAdapter?.mList = beans
        mList = beans
        mAdapter?.notifyDataSetChanged()
    }

    override fun getLayoutResources(): Int {
//        return R.layout.find_fragment//
        return 0
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater!!.inflate(R.layout.find_fragment,container,false)

        return inflater!!.inflate(R.layout.find_recycle_fragment,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_find.hasFixedSize()
        recyclerView_find.addItemDecoration(MaterialViewPagerHeaderDecorator())//为RecycleView的头部item添加与ViewPagerStrip之间的间距


    }
    override fun initView() {
        mPresenter = FindPresenter(context,this)
        mPresenter?.start()
        mAdapter = FindAdapter(context,mList)
        recyclerView_find.adapter=mAdapter
         recyclerView_find.layoutManager = GridLayoutManager(context,2)
        refreshLayout_find.setOnRefreshListener(this)

//        gv_find.adapter = mAdapter
//        gv_find.setOnItemClickListener { parent, view, position, id ->
//            var bean = mList?.get(position)
//            var name = bean?.name
//            var intent : Intent = Intent(context, FindDetailActivity::class.java)
//            intent.putExtra("name",name)
//            startActivity(intent)
//
//        }


    }

}
