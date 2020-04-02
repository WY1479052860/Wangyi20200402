package com.bawei.wangyi20200402.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.bawei.wangyi20200402.R;
import com.bawei.wangyi20200402.base.BaseActivity;
import com.bawei.wangyi20200402.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends BaseActivity {

    private TabLayout tab;
    private ViewPager vp;
    List<String> tabs=new ArrayList<>();
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_order;
    }

    @Override
    protected void initView() {
        tab = findViewById(R.id.tab);
        vp = findViewById(R.id.vp);
        tabs.add("全部");
        tabs.add("待付款");
        tabs.add("待发货");
        tabs.add("待收货");
        tabs.add("待评价");

        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        tab.addTab(tab.newTab().setText(tabs.get(2)));
        tab.addTab(tab.newTab().setText(tabs.get(3)));
        tab.addTab(tab.newTab().setText(tabs.get(4)));

    }

    @Override
    protected void initData() {

    }
}
