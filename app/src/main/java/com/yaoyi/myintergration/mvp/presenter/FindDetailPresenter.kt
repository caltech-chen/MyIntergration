package com.yaoyi.myintergration.mvp.presenter

import android.content.Context
import com.yaoyi.myintergration.mvp.contract.FindDetailContract
import com.yaoyi.myintergration.mvp.model.FindDetailModel
import com.yaoyi.myintergration.mvp.model.bean.HotBean
import com.yaoyi.myintergration.utils.applySchedulers
import io.reactivex.Observable

/**
 * Created by c on 2018/1/24.
 */
class FindDetailPresenter (context: Context, view: FindDetailContract.View) : FindDetailContract.Presenter {


    var mContext: Context? = null
    var mView: FindDetailContract.View? = null
    val mModel: FindDetailModel by lazy {
        FindDetailModel()
    }

    init {
        mView = view
        mContext = context
    }

    override fun start() {

    }

    override fun requestData(categoryName: String, strategy: String) {
        val observable: Observable<HotBean>? = mContext?.let { mModel.loadData(mContext!!, categoryName, strategy) }
        observable?.applySchedulers()?.subscribe { bean: HotBean ->
            mView?.setData(bean)
        }
    }

    fun requesMoreData(start: Int, categoryName: String, strategy: String) {
        val observable: Observable<HotBean>? = mContext?.let { mModel.loadMoreData(mContext!!, start, categoryName, strategy) }
        observable?.applySchedulers()?.subscribe { bean: HotBean ->
            mView?.setData(bean)
        }
    }


}