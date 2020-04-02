package com.bawei.wangyi20200402.base;

import java.lang.ref.WeakReference;

/**
 * BasePresenter封装
 */
public abstract class BasePresenter<V extends BaseView> {

    private  WeakReference<V> weakReference;

    public BasePresenter(V v) {
        weakReference = new WeakReference<>(v);
        initModel();
    }
    public V getView(){
        if(weakReference!=null){
            return weakReference.get();
        }
        return null;
    }
    public void datchView(){
        if(weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }

    protected abstract void initModel();
}
