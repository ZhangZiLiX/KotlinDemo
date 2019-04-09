package com.wd.kotlindemo.bean

/**
 * Author : 张自力
 * Created on time.
 *
 * 用户实体类
 */
data class UserBean(
        val message: String,
        val result: Result,
        val status: String
) {
    data class Result(
            val headPic: String,
            val nickName: String,
            val phone: String,
            val sessionId: String,
            val sex: Int,
            val userId: Int
    )
}