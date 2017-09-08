package com.z7dream.kotlinmvp.mvp.model

import com.z7dream.android_kotlin_mvp.base.model.BaseService
import com.z7dream.kotlinmvp.api.ApiClient
import io.reactivex.schedulers.Schedulers

/**
 * Created by Z7Dream on 2017/9/8 16:34.
 * Email:zhangxyfs@126.com
 */
class MainService : BaseService() {

    fun getData(page: Int) {
        ApiClient.getData(SIZE, page)
                .subscribeOn(Schedulers.io())
                .map {  }
    }


    companion object {
        val SIZE: Int = 20;
    }
}