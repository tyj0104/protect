package com.example.jay.myapplication;

import com.example.jay.myapplication.net.ApiHelper;

import org.junit.Test;

/**
 * Created by jay on 2017/10/18.
 */

public class ServiceListTest {
    private  String sub_code = "8A0731CC39614C90A5D474BC17253713";
    private  String sub_usercode = "414A6DB3BBE6419DA3768E6E25127310";
    private  String  param_name  ="A01_APP_Login";
    private String um = "aaa";
    private String pwd = "bbb";
    private String namme = "ccc";
    private String provider = "1";
    private String xieyi = "0";
    private String demander = "1";
    private String session_id = "A894B0D8-D26B-46CE-A575-5125A10628B6"; //用户登录Session_ID
    private String login_id = "aaa";    // 登录账号(用户手机号)
    private String  param_value1 = "0";  // 登录账号(用户手机号)
    private String  param_value2 = "0";  // 登录账号(用户手机号)
    private String  param_value3 = "0";  // 登录账号(用户手机号)
    private String  param_value4 = "0";  // 登录账号(用户手机号)
    private String  param_value5 = "0";  // 登录账号(用户手机号)

    @Test
    public void regest (){
        ApiHelper.getApi().regest(sub_code,sub_usercode,"A01_APP_Register",pwd,namme,demander,provider,xieyi)
                .blockingFirst();
    }


    @Test
    public void login (){
        ApiHelper.getApi().login(sub_code,sub_usercode,"A01_APP_Login",namme,pwd,namme,provider)
                .blockingFirst();
    }

    @Test
    public void serviceList(){
        ApiHelper.getApi().SelServList1(sub_code,sub_usercode,"A01_APP_SelServList1","34664008-769C-4EE5-ACD4-3F9C824C3B09","aaa","aaa","0","10")
                .blockingFirst();
    }
    @Test
    public void upd_user(){
        ApiHelper.getApi().Upd_eova_user(sub_code,sub_usercode," A01_APP_Upd_eova_user2","9A058E06-68AE-4895-9609-7FB255C16D3B","18888888888"
                ,"18888888888","aaa","3,","bbb","17777777777","1","11","22","33","44")
                .blockingFirst();
    }


}
