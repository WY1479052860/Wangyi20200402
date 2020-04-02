package com.bawei.wangyi20200402.model;

import com.bawei.wangyi20200402.bean.Loginbean;
import com.bawei.wangyi20200402.contract.LoginContract;
import com.bawei.wangyi20200402.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * m 层
 */
public class LoginModel implements LoginContract.IModel{
    @Override
    public void doLogin(String phone, String pwd, final IModelCallBack callBack) {
        NetUtils.getInstance().getApis().dologin(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Loginbean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Loginbean loginbean) {
                        if(callBack!=null){
                            callBack.LoginSuccess(loginbean);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if(callBack!=null){
                            callBack.LoginFailure(e.getMessage());
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
