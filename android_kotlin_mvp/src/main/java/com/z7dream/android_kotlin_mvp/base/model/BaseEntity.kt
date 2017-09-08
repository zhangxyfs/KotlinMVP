package com.z7dream.android_kotlin_mvp.base.model

import android.text.TextUtils

/**
 * Created by Z7Dream on 2017/9/6 13:26.
 * Email:zhangxyfs@126.com
 */
open class BaseEntity<T> {
    public var result: String? = null;
    public var code: String? = null;
    public var message: String? = null;

    public var data: T? = null;

    public fun isOK(): Boolean {
        return TextUtils.equals(code, "0000");
    }
}