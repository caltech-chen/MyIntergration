package com.yaoyi.myintergration.mvp.model

import android.content.Context
import com.yaoyi.myintergration.NetWork.ApiService
import com.yaoyi.myintergration.NetWork.RetrofitClient
import com.yaoyi.myintergration.mvp.model.bean.HomeBean
import io.reactivex.Observable

/**
 * Created by c on 2018/1/24.
 */
class HomeModel {
    fun loadData(context: Context, isFirst: Boolean, data: String?): Observable<HomeBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService  = retrofitClient.create(ApiService::class.java)
        when(isFirst) {
            true -> return apiService?.getHomeData()

            false -> return apiService?.getHomeMoreData(data.toString(), "2")
        }
    }
}