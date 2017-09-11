package com.z7dream.kotlinmvp

import android.app.Application
import com.z7dream.android_kotlin_mvp.utils.net.OKHTTP

/**
 * Created by Z7Dream on 2017/9/7 14:39.
 * Email:zhangxyfs@126.com
 */
class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        OKHTTP
                .get()
                .setDebug(true)//开启debug模式
                .init(null, null)//初始化
    }
}