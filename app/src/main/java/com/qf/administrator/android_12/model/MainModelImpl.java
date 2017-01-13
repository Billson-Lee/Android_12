package com.qf.administrator.android_12.model;

/**
 * Created by Administrator on 2017/1/12.
 * TODO 用于配合MainActivity逻辑部分
 */

public class MainModelImpl implements IloginModel{
    public  interface  LoginCallBack{
        void loginSuccess(String result);
        void loginError(String error);
    }
    @Override
    public void login(String userName,String passWord,LoginCallBack callBack){
        //TODO 本地验证  网络请求  返回登录结果
        String result = userName+passWord;
        //回调接口
        callBack.loginSuccess(result);
        //callBack.loginError("登录失败");
    }
}
