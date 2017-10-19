package com.example.jay.myapplication.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.bean.UserInfo;
import com.example.jay.myapplication.net.ApiHelper;

import java.net.URI;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        printLog();

     //   test();

    }

    private void test() {
        ApiHelper.getApi().SelServList1(UserInfo.getInstance().sub_code, UserInfo.getInstance().getSub_usercode(),
                "A01_APP_SelServList1", UserInfo.getInstance().getSession_id(), UserInfo.getInstance().getLogin_id(),
                UserInfo.getInstance().getNickname())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> {
                    System.out.println(o.toString());
                });
    }

    private void printLog() {
        Log.e("MainActivity", "Login_id ==== " + UserInfo.getInstance().getLogin_id());
        Log.e("MainActivity", "Session_id ==== " + UserInfo.getInstance().getSession_id());
        Log.e("MainActivity", "Nickname ==== " + UserInfo.getInstance().getNickname());
        Log.e("MainActivity", "ALI_ACCOUNT ==== " + UserInfo.getInstance().getALI_ACCOUNT());
        Log.e("MainActivity", "M_ACCOUNT ==== " + UserInfo.getInstance().getM_ACCOUNT());
        Log.e("MainActivity", "getSub_code ==== " + UserInfo.getInstance().getSub_code());
        Log.e("MainActivity", "Sub_usercode ==== " + UserInfo.getInstance().getSub_usercode());
    }
}
