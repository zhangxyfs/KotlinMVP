package com.z7dream.kotlinmvp

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.z7dream.android_kotlin_mvp.ui.BaseActivity
import com.z7dream.android_kotlin_mvp.utils.RxBus
import com.z7dream.android_kotlin_mvp.utils.RxSchedulersHelper
import io.reactivex.Observable

class MainActivity : BaseActivity<MainContract.Presenter, Application>(), MainContract.View {
    private var observable: Observable<String>? = null;

    override fun init(savedInstanceState: Bundle?) {
        getHandler()?.postDelayed({
            getPresenter()?.getData(true)
        }, 1000)

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

    override fun createPreseneter(): MainPresenter {
        return MainPresenter(this, this)
    }

    override fun layoutID(): Int {
        return R.layout.activity_main
    }

    override fun getDataSucc(isRef: Boolean) {
        Toast.makeText(this, "succ", Toast.LENGTH_SHORT).show();
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.get()?.unregister("test", observable);

    }
}
