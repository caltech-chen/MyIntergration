package com.yaoyi.myintergration.mvp.contract

import com.yaoyi.myintergration.base.BasePresenter
import com.yaoyi.myintergration.base.BaseView
import com.yaoyi.myintergration.mvp.model.bean.FindBean

/**
 * Created by c on 2018/1/24.
 */
interface FindContract {
    interface View : BaseView<Presenter> {
        fun setData(beans: MutableList<FindBean>)
    }

    interface Presenter : BasePresenter {
        fun requestData()
    }
}