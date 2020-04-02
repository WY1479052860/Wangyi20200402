package com.bawei.wangyi20200402.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.wangyi20200402.R;
import com.bawei.wangyi20200402.base.BaseActivity;
import com.bawei.wangyi20200402.base.BasePresenter;
import com.bawei.wangyi20200402.bean.Loginbean;
import com.bawei.wangyi20200402.contract.LoginContract;
import com.bawei.wangyi20200402.presenter.LoginPresenter;

public class MainActivity extends BaseActivity implements LoginContract.IView {


    private EditText et_name,et_pwd;
    private Button bt;

    @Override
    protected BasePresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
        bt = findViewById(R.id.bt);

    }

    @Override
    protected void initData() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = et_name.getText().toString();
                String pwd = et_pwd.getText().toString();
                BasePresenter presenter = getPresenter();
                if(presenter instanceof LoginPresenter){
                    ((LoginPresenter) presenter).doLogin(phone,pwd);
                }
            }
        });

    }

    @Override
    public void LoginSuccess(Loginbean bean) {
        String message = bean.getMessage();
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void LoginFailure(String str) {

    }
}
