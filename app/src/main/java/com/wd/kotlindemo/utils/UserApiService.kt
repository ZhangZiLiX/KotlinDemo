package com.wd.kotlindemo.utils

import com.wd.kotlindemo.bean.UserBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

/**
 * Author : 张自力
 * Created on time.
 */
interface UserApiService{

    @POST
    @FormUrlEncoded
    fun login(@Url string: String, @FieldMap hashMap: HashMap<String,String>): Observable<UserBean>

}