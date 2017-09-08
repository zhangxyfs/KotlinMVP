package com.z7dream.kotlinmvp.api

import com.z7dream.android_kotlin_mvp.base.model.BaseEntity
import com.z7dream.android_kotlin_mvp.utils.net.OKHTTP
import com.z7dream.kotlinmvp.api.entity.MainEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Z7Dream on 2017/9/8 17:25.
 * Email:zhangxyfs@126.com
 */
internal interface RequestManager {
    companion object {
        val REQUEST = OKHTTP.get().getRetrofit().create<RequestManager>(RequestManager::class.java);
    }

    @GET("mainList/{size}/{page}")
    fun getMainData(@Path("size") size: Int, page: Int): Observable<BaseEntity<List<MainEntity>>>
}