package com.z7dream.kotlinmvp

import com.z7dream.android_kotlin_mvp.base.view.BaseContract


/**
 * Created by Z7Dream on 2017/9/6 10:20.
 * Email:zhangxyfs@126.com
 */
interface MainContract : BaseContract.BaseView {
    interface View : BaseContract.BaseView {
        fun getDataSucc(isRef: Boolean)
    }

    interface Presenter : BaseContract.BasePresenter {
        fun getData(isRef: Boolean)
    }
}