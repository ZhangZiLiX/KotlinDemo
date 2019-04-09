package com.wd.kotlindemo.bean

import javax.xml.transform.Result

/**
 * Author : 张自力
 * Created on time.
 *
 * 商品封装类
 */

data class ShopBean(
    val message: String,
    val result: List<Result>,
    val status: String
    ) {
        data class Result(
                val commodityId: Int,
                val commodityName: String,
                val masterPic: String,
                val price: Int,
                val saleNum: Int
        )
}
