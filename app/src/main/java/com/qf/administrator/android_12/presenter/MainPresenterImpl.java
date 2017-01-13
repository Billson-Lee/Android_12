package com.qf.administrator.android_12.presenter;

import com.qf.administrator.android_12.model.MainModelImpl;
import com.qf.administrator.android_12.view.ILoginView;
import com.qf.administrator.android_12.view.MainActivity;

/**
 * Created by Administrator on 2017/1/12.
 */

public class MainPresenterImpl implements ILoginPresenter{
    private MainModelImpl mainModel;
    private ILoginView iLoginView;

    public MainPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        mainModel = new MainModelImpl();
    }
    @Override
    public void login(){
        //TODO view 和 model融合的一个场所
        String passWord = iLoginView.getPassWord();
        String userName = iLoginView.getUserName();

        iLoginView.showDialog();

        mainModel.login(userName, passWord, new MainModelImpl.LoginCallBack() {
            @Override
            public void loginSuccess(String result) {
                iLoginView.dismissDialog();
                iLoginView.loginSuccess(result);
            }

            @Override
            public void loginError(String error) {
                iLoginView.dismissDialog();
                iLoginView.loginError(error);
            }
        });

    }
}
