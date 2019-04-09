package com.wd.kotlindemo.constract

import android.content.Context
import com.wd.kotlindemo.bean.UserBean
import com.wd.kotlindemo.item.IModelCallback
import java.security.AccessControlContext

/**
 * Author : 张自力
 * Created on time.
 *
 * 契约类统一管理
 */
interface LoginConstract{

    //Presenter层接口
    interface ILoginPresenter{
       fun login(hashMap: HashMap<String,String>,context: Context)
    }

    //Model层接口
    interface ILoginModel{
        fun login(hashMap: HashMap<String, String>, context: Context, modelIModelCallback: IModelCallback<UserBean>)
    }

    //接口回调
    interface ILoginView{
        fun success(userBean: UserBean)
        fun failed(string: String)
    }

}