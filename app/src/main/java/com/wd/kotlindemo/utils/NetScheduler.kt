package com.wd.kotlindemo.utils

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Author : 张自力
 * Created on time.
 */
/**
 * 线程调度器
 */
object NetScheduler{
    fun <T> compose(): ObservableTransformer<T, T> {

        return ObservableTransformer {
            observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }
}