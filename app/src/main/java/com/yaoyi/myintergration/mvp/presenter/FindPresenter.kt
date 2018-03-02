package com.yaoyi.myintergration.mvp.presenter

import android.content.Context
import com.yaoyi.myintergration.mvp.contract.FindContract
import com.yaoyi.myintergration.mvp.model.FindModel
import com.yaoyi.myintergration.mvp.model.bean.FindBean
import com.yaoyi.myintergration.utils.applySchedulers
import io.reactivex.Observable

/**
 * Created by c on 2018/1/24.
 */
class FindPresenter(context: Context, view : FindContract.View) : FindContract.Presenter {
    var mContext: Context? = null
    var mView: FindContract.View? = null
    val mModel: FindModel by lazy {
        FindModel()
    }

    init {
        mView = view
        mContext = context
    }

    override fun start() {
        requestData()
    }

    override fun requestData() {
        val observable: Observable<MutableList<FindBean>>? = mContext?.let { mModel.loadData(mContext!!) }
        observable?.applySchedulers()?.subscribe { beans: MutableList<FindBean> ->
            mView?.setData(beans)
        }
    }

}