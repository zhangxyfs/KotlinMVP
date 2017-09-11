package com.z7dream.kotlinmvp.mvp.presenter

import android.content.Context
import android.os.Bundle
import com.z7dream.android_kotlin_mvp.base.presenter.Presenter
import com.z7dream.kotlinmvp.mvp.model.Main1Service
import com.z7dream.kotlinmvp.mvp.model.MainService
import com.z7dream.kotlinmvp.mvp.view.Main1Contract

/**
 * Created by Z7Dream on 2017/9/11 13:15.
 * Email:zhangxyfs@126.com
 */
class Main1Presenter(context: Context, view: Main1Contract.View) : Presenter<Main1Contract.View, MainService>(context, view), Main1Contract.Presenter {
    private var mMain1Service: Main1Service? = null;

    override fun createUI(savedInstanceState: Bundle?) {
        getView()?.createUISucc(mMain1Service?.getCacheData())
    }

    override fun createService(): MainService {
        mMain1Service = Main1Service()
        return MainService()
    };

    override fun detachView() {
        super.detachView()
        mMain1Service = null;
    }
}