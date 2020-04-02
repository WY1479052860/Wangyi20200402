package com.bawei.wangyi20200402.utils;

import com.bawei.wangyi20200402.bean.Loginbean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 接口
 */
public interface Apis {
    @POST("small/user/v1/login")
    @FormUrlEncoded
    Observable<Loginbean> dologin(@Field("phone") String username, @Field("pwd") String pwd);
}
