package com.example.jay.myapplication.net;


import com.example.jay.myapplication.bean.LoginBen;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * api 接口
 *
 * @author TianYingJie
 * @date 2017/10/17
 */

public interface Api {
    String baseUrl = "http://106.14.123.217:8089/";

    /**
     * sub_code=8A0731CC39614C90A5D474BC17253713&sub_usercode=414A6DB3BBE6419DA3768E6E25127310
     * 注册
     *
     * @param um       账号
     * @param pwd      密码
     * @param name     姓名
     * @param provider 是否服务方 0 否，1 是
     * @param demander 是否需求方 0 否，1 是
     * @param xieyi    是否可协议  0 否，1 是
     * @return
     */

    @FormUrlEncoded
    @POST("CenterData")
    Observable<Object> regest(
            @Query("sub_code") String sub_code,
            @Query("sub_usercode") String sub_usercode,
            @Query("param_name") String A01_APP_Register,
            @Field("param_value1") String um,
            @Field("param_value2") String pwd,
            @Field("param_value3") String name,
            @Field("param_value4") String provider,
            @Field("param_value5") String demander,
            @Field("param_value6") String xieyi
    );


    /**
     *
     * 注册
     *
     * @param um       账号
     * @param pwd      密码
     * @param name     姓名
     * @param provider 是否服务方 0 否，1 是
     * @return
     */

    @FormUrlEncoded
    @POST("CenterData")
    Observable<Object> login(
             @Query("sub_code") String sub_code,
             @Query("sub_usercode") String sub_usercode,
             @Query("param_name") String A01_APP_Login,
             @Field("param_value1") String um,
             @Field("param_value2") String pwd,
             @Field("param_value3") String name,
             @Field("param_value4") String provider

    );


}
