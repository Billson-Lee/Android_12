package com.qf.administrator.android_12.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.qf.administrator.android_12.R;
import com.qf.administrator.android_12.presenter.MainPresenterImpl;

/**
 * TODO Mvp
 *      M  model 业务逻辑模块
 *      v  view  视图界面模块
 *      p  presenter 联合模块
 *
 *      区分  逻辑模块 视图模块
 *      1. view
 *          1，按钮的点击事件
 *          TODO 使用p 进行view 和 model的关联
 *          2，获取账号密码
 *          TODO 获取EditText的输入内容
 *          3，操作提示框
 *          TODO 操作Dialog
 *          4，成功和失败的方法
 *          TODO 告诉View是否否登陆成功
 *      2. model
 *          1，登陆的逻辑
 *          TODO 创建一个方法 具体去写登录
 *      3.presenter
 *          1,登录的关联
 *          TODO 进行view和Activity的登录关联
 */
public class MainActivity extends AppCompatActivity implements ILoginView{
    private EditText userName;
    private EditText passWord;
    private MainPresenterImpl mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.userName);
        passWord = (EditText) findViewById(R.id.passWord);
        mainPresenter = new MainPresenterImpl(this);
    }
    //获取账号
    @Override
    public String getUserName(){
        return userName.getText().toString();
    }
    //获取密码
    @Override
    public String getPassWord(){
        return passWord.getText().toString();
    }
    //弹出提示框
    @Override
    public void showDialog(){
        Log.e("TAG","showDialog:");
    }
    //关闭提示框
    @Override
    public void dismissDialog(){
        Log.e("TAG","dismissDialog:");
    }
    //登陆成功
    @Override
    public void loginSuccess(String result){
        Log.e("TAG","loginSuccess:"+result);
    }

    @Override
    public void loginError(String error) {

    }


    public void btnClick(View view) {
        mainPresenter.login();
    }
}
