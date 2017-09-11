package com.z7dream.kotlinmvp.mvp.view

import com.z7dream.android_kotlin_mvp.base.view.BaseContract
import com.z7dream.kotlinmvp.mvp.ui.model.MainModel


/**
 * Created by Z7Dream on 2017/9/6 10:20.
 * Email:zhangxyfs@126.com
 */
interface MainContract : BaseContract.BaseView {
    interface View : BaseContract.BaseView {
        fun getDataSucc(modelList: List<MainModel>, isRef: Boolean)

        fun getDataFail(str: String?)
    }

    interface Presenter : BaseContract.BasePresenter {
        fun getData(isRef: Boolean)
    }
}