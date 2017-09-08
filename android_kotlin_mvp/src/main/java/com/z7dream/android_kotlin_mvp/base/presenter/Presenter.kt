package com.z7dream.android_kotlin_mvp.base.presenter

import android.content.Context
import android.widget.Toast
import com.z7dream.android_kotlin_mvp.base.view.BaseContract

/**
 * P 层实现
 *
 * Created by Z7Dream on 2017/9/6 10:26.
 * Email:zhangxyfs@126.com
 */
abstract class Presenter<V : BaseContract.BaseView>(context: Context, view: V):BaseContract.BasePresenter {
    private var mView: V? = view;
    private var mContext: Context? = context;
    private var mToast: Toast? = null;

    protected fun getView(): V? {
        return mView;
    }

    protected fun getContext(): Context? {
        return mContext;
    }

    override fun detachView() {
        mView = null;
        mContext = null;
    }

    protected fun showToast(resId: Int) {
        showToast(getContext()?.resources?.getString(resId) ?: "");
    }

    protected fun showToast(s: String) {
        if (getContext() == null) return
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }
}