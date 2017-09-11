package com.z7dream.kotlinmvp.mvp.view

import android.os.Bundle
import com.z7dream.android_kotlin_mvp.base.view.BaseContract

/**
 * Created by Z7Dream on 2017/9/11 13:23.
 * Email:zhangxyfs@126.com
 */
interface Main1Contract : BaseContract.BaseView {
    interface Presenter : BaseContract.BasePresenter {
        fun createUI(savedInstanceState: Bundle?);
    }

    interface View : BaseContract.BaseView {
        fun createUISucc(str : String?);
    }
}