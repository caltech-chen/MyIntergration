package com.yaoyi.myintergration.mvp.model

import android.content.Context
import com.yaoyi.myintergration.NetWork.ApiService
import com.yaoyi.myintergration.NetWork.RetrofitClient
import com.yaoyi.myintergration.mvp.model.bean.FindBean
import io.reactivex.Observable

/**
 * Created by c on 2018/1/24.
 */
class FindModel {
    fun loadData(context: Context): Observable<MutableList<FindBean>>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getFindData()
    }
}
