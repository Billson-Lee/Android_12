package com.qf.administrator.android_12.model;

/**
 * Created by Administrator on 2017/1/12.
 */

public interface IloginModel {
    // TODO 登录逻辑
    void login(String userName, String passWord, MainModelImpl.LoginCallBack callBack);
}
