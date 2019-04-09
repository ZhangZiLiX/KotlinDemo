package com.wd.kotlindemo.presenter

import android.content.Context
import com.wd.kotlindemo.bean.UserBean
import com.wd.kotlindemo.constract.LoginConstract
import com.wd.kotlindemo.item.IModelCallback
import com.wd.kotlindemo.model.LoginModel

/**
 * Author : 张自力
 * Created on time.
 */
class LoginPresenter : LoginConstract.ILoginPresenter {

    //声明对象
    lateinit var loginModel:LoginModel
    lateinit var iLoginView:LoginConstract.ILoginView

    //绑定方法
    fun attach(iLoginView: LoginConstract.ILoginView){
        this.iLoginView=iLoginView
        loginModel = LoginModel()
    }

    /**
     * 登录方法
     *
     * */
    override fun login(hashMap: HashMap<String, String>, context: Context) {
        loginModel.login(hashMap,context,object : IModelCallback<UserBean>{
            override fun sucess(data: UserBean) {
                //成功返回
                iLoginView?.success(data)

            }

            override fun failed(string: String) {
                //失败的方法
                iLoginView.failed(string)
            }

        })
    }

    //解绑
    fun detach() {
        if(iLoginView !=null){
            iLoginView == null
        }

    }

}