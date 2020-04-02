package com.bawei.wangyi20200402.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bawei.wangyi20200402.R;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{
    P presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        presenter=initPresenter();
        initView();
        initData();
    }

    public P getPresenter() {
        return presenter;
    }

    protected abstract P initPresenter();
    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter !=null){
            presenter.datchView();
            presenter=null;
        }
    }
}
