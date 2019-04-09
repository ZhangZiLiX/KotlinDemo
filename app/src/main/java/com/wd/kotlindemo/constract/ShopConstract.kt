package com.wd.kotlindemo.constract

import android.content.Context
import com.wd.kotlindemo.bean.ShopBean
import com.wd.kotlindemo.item.IModelCallback

/**
 * Author : 张自力
 * Created on time.
 * 商品契约类
 */
interface ShopConstract{

    interface IShopPresenter{
        fun getShops(hashMap: HashMap<String,String>,context: Context)
    }

    interface IShopModel{
        fun getShops(hashMap: HashMap<String, String>, context: Context, modelIModelCallback: IModelCallback<ShopBean>)
    }

    interface IProductView{

        fun success(shopBean: ShopBean)
        fun failed(string: String)

    }


}

