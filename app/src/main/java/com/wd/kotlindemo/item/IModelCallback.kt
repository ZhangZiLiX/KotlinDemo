package com.wd.kotlindemo.item

/**
 * Author : 张自力
 * Created on time.
 *
 * 接口回调
 */
interface IModelCallback<T>{

    fun sucess(data: T)
    fun failed(string: String)

}