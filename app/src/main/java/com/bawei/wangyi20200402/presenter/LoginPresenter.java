package com.bawei.wangyi20200402.presenter;

import android.util.Log;

import com.bawei.wangyi20200402.base.BasePresenter;
import com.bawei.wangyi20200402.base.BaseView;
import com.bawei.wangyi20200402.bean.Loginbean;
import com.bawei.wangyi20200402.contract.LoginContract;
import com.bawei.wangyi20200402.model.LoginModel;

/**
 * p层
 */
public class LoginPresenter extends BasePresenter implements LoginContract.IPresenter {

    private LoginModel model;

    public LoginPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    protected void initModel() {
        model = new LoginModel();
    }

    @Override
    public void doLogin(String phone, String pwd) {
        model.doLogin(phone, pwd, new LoginContract.IModel.IModelCallBack() {
            @Override
            public void LoginSuccess(Loginbean bean) {
                BaseView view = getView();
                if(view instanceof LoginContract.IView){
                    ((LoginContract.IView) view).LoginSuccess(bean);
                }
            }

            @Override
            public void LoginFailure(String str) {
                BaseView view = getView();
                if(view instanceof LoginContract.IView){
                    ((LoginContract.IView) view).LoginFailure(str);
                }
            }
        });

    }
}
