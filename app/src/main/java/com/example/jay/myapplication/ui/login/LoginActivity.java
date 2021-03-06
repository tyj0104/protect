package com.example.jay.myapplication.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.base.activity.BaseActivity;
import com.example.jay.myapplication.bean.LoginModel;
import com.example.jay.myapplication.bean.UserInfo;
import com.example.jay.myapplication.net.ApiHelper;
import com.example.jay.myapplication.ui.main.MainActivity;
import com.example.jay.myapplication.ui.register.RegisterActivity;
import com.example.jay.myapplication.utils.JsonUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/10/17
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
//sub_code=8A0731CC39614C90A5D474BC17253713&
// sub_usercode=414A6DB3BBE6419DA3768E6E25127310&
// param_name=A01_APP_Login&param_value1=aaa&param_value2=bbb&param_value3=1&param_value4=0

    private EditText userName;
    private EditText passWord;
    private RadioButton select01;
    private RadioButton select02;
    private int xq = -1;//是否是服务方，1为需求方，2为服务方
    private String param_name = "A01_APP_Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //第一次安装APP时，启动APP后按Home回卓面再按图标回到APP中时会重启Activity。此方法可以解决此问题
        if (!isTaskRoot()) {
            finish();
            return;
        }
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
//        TextView weixinlogin = (TextView) findViewById(R.id.login_wei_xin_login);
        TextView login = (TextView) findViewById(R.id.login_login);
        TextView register = (TextView) findViewById(R.id.login_register);
//        select01 = (RadioButton) findViewById(R.id.login_select_01);
//        select02 = (RadioButton) findViewById(R.id.login_select_02);

        userName = (EditText) findViewById(R.id.login_user_name_ed);
        passWord = (EditText) findViewById(R.id.login_user_password_ed);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
//        weixinlogin.setOnClickListener(this);
//        select02.setOnClickListener(this);
//        select01.setOnClickListener(this);
//        init();
    }

    /**
     * 样板
     *
     * @param user
     * @param pass
     */
    private void login(String user, String pass) {
        ApiHelper.getApi().login(ApiHelper.sub_code, ApiHelper.sub_usercode, param_name, user, pass, xq == 1 ? "1" : "0", xq == 1 ? "0" : "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> {
                    LoginModel loginModel = JsonUtil.fromJson(o, LoginModel.class);
                    if (loginModel == null) {
//                        Toast.makeText(LoginActivity.this, "网络出现了问题", Toast.LENGTH_SHORT).show();
                        showToast(LoginActivity.this, "网络出现了问题");
                        return;
                    }
                    LoginModel.A01APPLoginBean loginBean = loginModel.getA01_APP_Login().get(0);
                    if ("1".equals(loginBean.getS_result())) {
                        cancelLoadingDialog(LoginActivity.this);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        /**
                         * 保存用户登录信息
                         */
                        setUserInfo(loginBean);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, loginBean.getError_desc(), Toast.LENGTH_SHORT).show();
                    }
                    Log.e("test", "  请求结果 ===>" + o.toString());
                }, e -> Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show());
    }

    /**
     * 保存用户登录信息
     *
     * @param loginBean
     */
    private void setUserInfo(LoginModel.A01APPLoginBean loginBean) {
        UserInfo.getInstance().setSession_id(loginBean.getSession_id());
        UserInfo.getInstance().setLogin_id(loginBean.getLogin_id());
        UserInfo.getInstance().setNickname(loginBean.getNickname());
        UserInfo.getInstance().setALI_ACCOUNT(loginBean.getALI_ACCOUNT());
        UserInfo.getInstance().setM_ACCOUNT(loginBean.getM_ACCOUNT());
        UserInfo.getInstance().setXuQiuFang(xq == 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_login:
                String user = userName.getText().toString().trim();
                String pass = passWord.getText().toString().trim();

//                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass) && xq != -1) {
//                    //请求登陆
//                    showLoadingDialog(LoginActivity.this, "登录中...");
//                    login(user, pass);
//                }

                login2();
                break;
            case R.id.login_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
//            case R.id.login_wei_xin_login:
//                break;
//            case R.id.login_select_01:
//                select02.setChecked(false);
//                xq = 1;
//                break;
//            case R.id.login_select_02:
//                select01.setChecked(false);
//                xq = 2;
//                break;
            default:
                break;
        }
    }

    private void login2() {
        UserInfo.getInstance().setXuQiuFang(true);
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }
}
