package com.z7dream.kotlinmvp.mvp.model

import com.z7dream.android_kotlin_mvp.base.model.BaseService
import com.z7dream.kotlinmvp.api.ApiClient
import com.z7dream.kotlinmvp.mvp.ui.model.MainModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Z7Dream on 2017/9/8 16:34.
 * Email:zhangxyfs@126.com
 */
class MainService : BaseService() {

    fun getData(page: Int): Observable<List<MainModel>> =
            ApiClient.getData(SIZE, page)
                    .subscribeOn(Schedulers.io())
                    .map { list ->
                        val modelList: MutableList<MainModel> = ArrayList<MainModel>()
                        for (entity in list) {
                            modelList.add(MainModel(entity.title, entity.url))
                        }
                        modelList
                    }


    companion object {
        val SIZE: Int = 20;
    }
}