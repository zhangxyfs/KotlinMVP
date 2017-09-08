package com.z7dream.kotlinmvp.api

import com.z7dream.android_kotlin_mvp.utils.net.OKHTTP

/**
 * Created by Z7Dream on 2017/9/8 17:25.
 * Email:zhangxyfs@126.com
 */
internal interface RequestManager {
    companion object {
        val REQUEST = OKHTTP.get().getRetrofit().create(this::class.java);
    }


}