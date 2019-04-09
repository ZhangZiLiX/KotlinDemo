package com.wd.kotlindemo.utils

import com.wd.kotlindemo.bean.ShopBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url

/**
 * Author : 张自力
 * Created on time.
 */

interface  ShopApiService{

    @GET
    fun getShops(@Url string: String, @QueryMap params:HashMap<String,String>): Observable<ShopBean>


}