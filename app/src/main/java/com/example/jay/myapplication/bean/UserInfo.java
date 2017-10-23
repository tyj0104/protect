package com.example.jay.myapplication.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jay on 2017/10/19.
 * 用户信息保存
 */

@Getter
@Setter
public final class UserInfo {
    /**
     * 当前用户实例
     **/
    @Getter
    @Setter
    private static UserInfo instance = new UserInfo() ;
    /**
     * 平台
     */
    public String sub_code = "8A0731CC39614C90A5D474BC17253713";

    /**
     * 平台
     */
    public String sub_usercode = "414A6DB3BBE6419DA3768E6E25127310";
    /**
     * 登录id
     */
    public String session_id;
    /**
     * 用户登录账号
     */
    public String login_id;

    /**
     * 用户姓名
     */
    public String nickname;
    /**
     * 绑定的支付宝ID
     */
    public String ALI_ACCOUNT;

    /**
     * 绑定的微信ID
     */
    public String M_ACCOUNT;

    /**
     * 是否是需求方
     */
    public boolean isXuQiuFang;

}
