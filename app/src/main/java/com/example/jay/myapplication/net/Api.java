package com.example.jay.myapplication.net;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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


    /**
     * 服务器最新5条数据
     *
     * @param sub_code
     * @param sub_usercode
     * @param A01_APP_SelServList1
     * @param session_id    用户登录Session_ID
     * @param login_id      登录账号(用户手机号)
     * @param param_value1  登录账号(用户手机号)
     * @param start 开始
     * @param end  结束
     * @return
     */
    @FormUrlEncoded
    @POST("CenterData")
    Observable<Object> SelServList1(
            @Query("sub_code") String sub_code,
            @Query("sub_usercode") String sub_usercode,
            @Query("param_name") String A01_APP_SelServList1,
            @Field("session_id") String session_id, // 用户登录Session_ID
            @Field("login_id") String login_id,   // 登录账号(用户手机号)
            @Field("param_value1") String param_value1 ,  // 登录账号(用户手机号)，
            @Field("param_value2") String start ,  // 登录账号(用户手机号)，
            @Field("param_value3") String end   // 登录账号(用户手机号)
    );


    /**
     * session_id			用户登录Session_ID
     * login_id			登录账号(用户手机号)
     * param_value1		登录账号(用户手机号)
     * param_value2  		所属单位
     * param_value3		所属区域
     * param_value4		姓名
     * param_value5		手机号
     * param_value6		性别
     * param_value7		所属专业
     * param_value8		学历
     * param_value9		工作年限
     * param_value10		QQ号码
     */

    @FormUrlEncoded
    @POST("CenterData")
    Observable<Object> Upd_eova_user(
            @Query("sub_code") String sub_code,
            @Query("sub_usercode") String sub_usercode,
            @Query("param_name") String A01_APP_Upd_eova_user2,

            @Query("session_id") String session_id,
            @Query("login_id") String login_id,
            @Query("param_value1") String phone,
            @Field("param_value2") String danwei,
            @Field("param_value3") String quyu,
            @Field("param_value4") String xingming,
            @Field("param_value5") String shoujihao,
            @Field("param_value6") String xingbie,
            @Field("param_value7") String zhuanye,
            @Field("param_value8") String xueli,
            @Field("param_value9") String nianxian,
            @Field("param_value10") String qq
    );
}
