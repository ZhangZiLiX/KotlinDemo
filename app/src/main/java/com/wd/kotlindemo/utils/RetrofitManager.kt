package com.wd.kotlindemo.utils

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.wd.kotlindemo.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Author : 张自力
 * Created on time.
 */
class RetrofitManager private constructor(){

    lateinit var retrofit:Retrofit

    /**
     * 单例模式
     *
     * */
    companion object {
        val instance : RetrofitManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitManager()
        }
    }

    fun init(string: String){
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY//测试模式
                else HttpLoggingInterceptor.Level.NONE
                ))
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(string)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    /**
     * 动态代理模式，创建请求接口类
     * @param tClass
     * @param <T>
     * @return
    </T> */
    fun <T> createService(tClass: Class<T>): T {

        return retrofit.create(tClass)
    }

}