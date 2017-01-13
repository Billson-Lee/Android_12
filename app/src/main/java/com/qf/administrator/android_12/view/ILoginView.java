package com.qf.administrator.android_12.view;

/**
 * Created by Administrator on 2017/1/12.
 * TODO 用于规范MainActivity
 */

public interface ILoginView {

    //TODO 以下方法用于登录逻辑
    String getUserName();
    String getPassWord();
    void showDialog();
    void dismissDialog();
    void loginSuccess(String result);
    void loginError(String error);

}
