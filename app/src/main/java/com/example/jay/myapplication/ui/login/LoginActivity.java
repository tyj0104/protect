package com.example.jay.myapplication.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.net.ApiHelper;
import com.example.jay.myapplication.net.Response;
import com.example.jay.myapplication.ui.register.RegisterActivity;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/10/17
 */

public class LoginActivity extends Activity implements View.OnClickListener {
//sub_code=8A0731CC39614C90A5D474BC17253713&
// sub_usercode=414A6DB3BBE6419DA3768E6E25127310&
// param_name=A01_APP_Login&param_value1=aaa&param_value2=bbb&param_value3=1&param_value4=0

    private EditText userName;
    private EditText passWord;
    private RadioButton select01;
    private RadioButton select02;
    private int xq = -1;//是否是服务方，1为需求方，2为服务方
    private  String sub_code = "8A0731CC39614C90A5D474BC17253713";
    private  String sub_usercode = "414A6DB3BBE6419DA3768E6E25127310";
    private  String  param_name  ="A01_APP_Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        TextView weixinlogin = (TextView) findViewById(R.id.login_wei_xin_login);
        TextView login = (TextView) findViewById(R.id.login_login);
        TextView register = (TextView) findViewById(R.id.login_register);
        select01 = (RadioButton) findViewById(R.id.login_select_01);
        select02 = (RadioButton) findViewById(R.id.login_select_02);

        userName = (EditText) findViewById(R.id.login_user_name_ed);
        passWord = (EditText) findViewById(R.id.login_user_password_ed);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
        weixinlogin.setOnClickListener(this);
        select02.setOnClickListener(this);
        select01.setOnClickListener(this);
        init();
    }

    /**
     * 样板
     */
    private void init() {

        ApiHelper.getApi().login(sub_code,sub_usercode,param_name,"aaa","bbb","1","0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        o -> {
                            System.out.println("  请求结果 ==="+o.toString());
                        }
                );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_login:
                String user = userName.getText().toString().trim();
                String pass = passWord.getText().toString().trim();

                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass) && xq != -1) {
                    //请求登陆
                }
                break;
            case R.id.login_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.login_select_01:
                select02.setChecked(false);
                xq = 1;
                break;
            case R.id.login_select_02:
                select01.setChecked(false);
                xq = 2;
                break;
            default:
                break;
        }
    }
}
