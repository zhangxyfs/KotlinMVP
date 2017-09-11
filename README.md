# KotlinMVP
kotlin版的MVP框架
##### 如何使用？
```
buildscript {
    ext.kotlin_version = '1.1.4-3'
    ext.rxlifecycle_version='2.0.1'
    ext.rxjava_version='2.x.y'
    ext.jsr305='1.3.9'
    ext.okhttp_version='3.8.1'
    ext.gson_version='2.4'
    ext.retrofit_version='2.2.0'
}

dependencies {
    compile "com.trello.rxlifecycle2:rxlifecycle:$rxlifecycle_version"
    compile "com.trello.rxlifecycle2:rxlifecycle-android:$rxlifecycle_version"
    compile "com.trello.rxlifecycle2:rxlifecycle-components:$rxlifecycle_version"
    compile "io.reactivex.rxjava2:rxjava:$rxjava_version"
    compile "io.reactivex.rxjava2:rxandroid:$rxjava_version"
    compile "com.squareup.okhttp3:okhttp:$okhttp_version"
    compile "com.squareup.okhttp3:okhttp-urlconnection:$okhttp_version"
    compile "com.squareup.okhttp3:logging-interceptor:$okhttp_version"
    compile "com.google.code.gson:gson:$gson_version"
    compile "com.squareup.retrofit2:retrofit:$retrofit_version"
    compile "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"
    compile "com.squareup.retrofit2:converter-gson:$retrofit_version"
    compile "com.squareup.retrofit2:converter-scalars:$retrofit_version"
}
```
在你的application里加入以下代码：
```kotlin
    override fun onCreate() {
        super.onCreate()
        OKHTTP
                .get()
                .setDebug(true)//开启debug模式
                .init(null, null)//初始化
    }
```