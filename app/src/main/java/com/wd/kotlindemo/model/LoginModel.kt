package com.wd.kotlindemo.model

import android.content.Context
import com.wd.kotlindemo.bean.UserBean
import com.wd.kotlindemo.constract.LoginConstract
import com.wd.kotlindemo.item.IModelCallback
import com.wd.kotlindemo.utils.Api
import com.wd.kotlindemo.utils.NetScheduler
import com.wd.kotlindemo.utils.RetrofitManager
import com.wd.kotlindemo.utils.UserApiService

/**
 * Author : 张自力
 * Created on time.
 *
 * model层  实现接口和方法
 */
class LoginModel:LoginConstract.ILoginModel {
    override fun login(hashMap: HashMap<String, String>, context: Context, modelIModelCallback: IModelCallback<UserBean>) {
        RetrofitManager.instance.createService(UserApiService::class.java).login(Api.LOGIN_URL,hashMap)
                .compose(NetScheduler.compose())
                .subscribe(object : NetResponseObserver<UserBean>(context){
                    override fun success(data: UserBean) {

                        modelCallback?.sucess(data)

                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {

                        modelCallback?.failure(apiErrorModel.message)
                    }

                })
    }
}
