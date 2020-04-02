package com.bawei.wangyi20200402.utils;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络工具类
 */
public class NetUtils {
    private Apis apis;
    private static final String BASE_URL="http://mobile.bwstudent.com/";
    //静态内部类单例模式
    private NetUtils(){
        initRetrofit();
    }
    private static class SingleInstance{
        private static final NetUtils INSTANCE=new NetUtils();
    }

    public static NetUtils getInstance() {
        return SingleInstance.INSTANCE;
    }
    //添加拦截器
    private void initRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor);
        OkHttpClient client = builder.build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apis=retrofit.create(Apis.class);
    }

    public Apis getApis() {
        return apis;
    }
}
