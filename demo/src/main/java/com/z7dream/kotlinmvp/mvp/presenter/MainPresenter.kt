package com.z7dream.kotlinmvp.mvp.presenter

import android.content.Context
import com.z7dream.android_kotlin_mvp.base.presenter.Presenter
import com.z7dream.kotlinmvp.mvp.model.MainService
import com.z7dream.kotlinmvp.mvp.view.MainContract

/**
 * Created by Z7Dream on 2017/9/6 15:33.
 * Email:zhangxyfs@126.com
 */
open class MainPresenter(context: Context, view: MainContract.View) : Presenter<MainContract.View, MainService>(context, view), MainContract.Presenter {
    private var page: Int = 0;
    override fun createService(): MainService {
        return MainService()
    }

    override fun getData(isRef: Boolean) {
        page = if (isRef) 0 else page++
        getService()
                .getData(page)
                .compose(getView()?.bindToLifecycle())
                .subscribe({ list ->
                    getView()?.getDataSucc(list, isRef);
                }, {
                    getView()?.getDataFail()
                })
    }

    override fun detachView() {
        super.detachView()
    }
}