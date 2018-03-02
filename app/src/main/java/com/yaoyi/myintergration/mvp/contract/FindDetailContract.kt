package com.yaoyi.myintergration.mvp.contract

import com.yaoyi.myintergration.base.BasePresenter
import com.yaoyi.myintergration.base.BaseView
import com.yaoyi.myintergration.mvp.model.bean.HotBean

/**
 * Created by c on 2018/1/24.
 */
interface FindDetailContract {
    interface View : BaseView<Presenter> {
        fun setData(bean: HotBean)
    }

    interface Presenter : BasePresenter {
        fun requestData(categoryName: String, strategy: String)
    }
}