package com.wd.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wd.kotlindemo.bean.UserBean
import com.wd.kotlindemo.constract.LoginConstract
import com.wd.kotlindemo.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener ,LoginConstract.ILoginView{


    override fun success(userBean: UserBean) {
        Toast.makeText(this, userBean.result.phone, Toast.LENGTH_SHORT).show()
    }

    override fun failed(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }


    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初始化
        initView()
        //初始化数据
        initData()

    }

    //初始化数据
    private fun initData() {
         //初始化登录的Presenter对象
        loginPresenter = LoginPresenter()


    }

    //初始化 并设置点击事件
    private fun initView() {
        btn_login.setOnClickListener(this)//登录按钮
    }

    //点击事件
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_login -> login()
        }
    }

    //登录点击方法
    fun login(){
        //"15516600031"  "123456"
        //关联
        loginPresenter.attach(this)
        var params = HashMap<String,String>()
        val userName = userName.text.toString()
        val userPaw = userPaw.text.toString()
        if(userName!=null||!userName.equals("") && userPaw!=null||!userPaw.equals("")){
            params.put("phone",userName)
            params.put("pwd",userPaw)
            //  使用Presenter层进行请求
            loginPresenter.login(params,this)
        }



    }

    /**
     * 销毁
     * */
    override fun onDestroy() {
        super.onDestroy()
        if(loginPresenter!=null){
            loginPresenter.detach()
        }
    }

}
