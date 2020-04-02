package com.bawei.wangyi20200402.contract;

import com.bawei.wangyi20200402.base.BaseView;
import com.bawei.wangyi20200402.bean.Loginbean;

/**
 * 契约类
 */
public interface LoginContract {
     interface IView extends BaseView{
         void LoginSuccess(Loginbean bean);
         void LoginFailure(String str);
     }
     interface IPresenter{
         void doLogin(String phone,String pwd);
     }
     interface IModel{
         void doLogin(String phone,String pwd,IModelCallBack callBack);
         interface IModelCallBack{
             void LoginSuccess(Loginbean bean);
             void LoginFailure(String str);
         }
     }
}
