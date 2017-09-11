package com.z7dream.kotlinmvp.mvp.ui

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.z7dream.android_kotlin_mvp.ui.BaseActivity
import com.z7dream.android_kotlin_mvp.utils.rx.RxBus
import com.z7dream.android_kotlin_mvp.utils.rx.RxSchedulersHelper
import com.z7dream.kotlinmvp.R
import com.z7dream.kotlinmvp.mvp.presenter.Main1Presenter
import com.z7dream.kotlinmvp.mvp.presenter.MainPresenter
import com.z7dream.kotlinmvp.mvp.ui.model.MainModel
import com.z7dream.kotlinmvp.mvp.view.Main1Contract
import com.z7dream.kotlinmvp.mvp.view.MainContract
import io.reactivex.Observable

class MainActivity : BaseActivity<MainContract.Presenter, Application>(), MainContract.View, Main1Contract.View {
    private var observable: Observable<String>? = null;
    private var mMain1Presenter: Main1Contract.Presenter? = null;

    override fun init(savedInstanceState: Bundle?) {
        mMain1Presenter?.createUI(savedInstanceState);
    }

    override fun createPreseneter(): MainPresenter {
        mMain1Presenter = Main1Presenter(this, this)
        return MainPresenter(this, this)
    }

    override fun layoutID(): Int {
        return R.layout.activity_main
    }

    override fun getDataSucc(modelList: List<MainModel>, isRef: Boolean) {
        Toast.makeText(this, "succ", Toast.LENGTH_SHORT).show();
    }

    override fun getDataFail(str: String?) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    override fun createUISucc(str: String?) {
        getPresenter()?.getData(true)
        getHandler()?.postDelayed({
            RxBus.get()?.post("test", "!!!")
        }, 2000)

        observable = RxBus.get()?.register("test", String::class.java);
        observable?.compose(RxSchedulersHelper.io_main())
                ?.subscribe({ v ->
                    Toast.makeText(this, v, Toast.LENGTH_SHORT).show();
                }, { error ->
                    Log.e("tag", error.message)
                });
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.get()?.unregister("test", observable);

    }
}
