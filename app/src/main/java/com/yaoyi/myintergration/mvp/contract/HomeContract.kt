package com.yaoyi.myintergration.mvp.contract

import com.yaoyi.myintergration.base.BasePresenter
import com.yaoyi.myintergration.base.BaseView
import com.yaoyi.myintergration.mvp.model.bean.HomeBean

/**
 * Created by c on 2018/1/24.
 */
interface HomeContract {

    interface View : BaseView<Presenter> {
        fun setData(bean : HomeBean)
    }
    interface Presenter : BasePresenter {
        fun requestData()
    }

}