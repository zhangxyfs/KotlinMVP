package com.z7dream.kotlinmvp.api

import com.z7dream.android_kotlin_mvp.utils.rx.RxResultHelper
import com.z7dream.kotlinmvp.api.entity.MainEntity
import io.reactivex.Observable

/**
 * Created by Z7Dream on 2017/9/8 18:02.
 * Email:zhangxyfs@126.com
 */
class ApiClient {

    companion object {
        fun getData(size: Int, page: Int): Observable<List<MainEntity>> {
            return RequestManager.REQUEST.getMainData(size, page).compose(RxResultHelper.handleResult());
        }
    }
}