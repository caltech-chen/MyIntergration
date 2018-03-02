package com.yaoyi.myintergration.mvp.presenter

import android.content.Context
import com.yaoyi.myintergration.mvp.contract.HomeContract
import com.yaoyi.myintergration.mvp.model.HomeModel
import com.yaoyi.myintergration.mvp.model.bean.HomeBean
import com.yaoyi.myintergration.utils.applySchedulers
import io.reactivex.Observable

/**
 * Created by c on 2018/1/24.
 */
class HomePresenter (context: Context, view : HomeContract.View) : HomeContract.Presenter{
    var mContext : Context? = null
    var mView : HomeContract.View? = null
    val mModel : HomeModel by lazy {
        HomeModel()
    }
    init {
        mView = view
        mContext = context
    }
    override fun start() {
        requestData()
    }

    override fun requestData() {
        val observable : Observable<HomeBean>? = mContext?.let { mModel.loadData(it,true,"0") }
        observable?.applySchedulers()?.subscribe { homeBean : HomeBean ->
            mView?.setData(homeBean)
        }
    }
    fun moreData(data: String?){
        val observable : Observable<HomeBean>? = mContext?.let { mModel.loadData(it,false,data) }
        observable?.applySchedulers()?.subscribe { homeBean : HomeBean ->
            mView?.setData(homeBean)
        }
    }


}