package com.example.jay.myapplication;

import android.app.Application;

/**
 * Created by Administrator on 2017/10/17
 */

public class XiaoerApplication extends Application {

    public static XiaoerApplication instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
    }

    public static XiaoerApplication getInstances() {
        return instances;
    }
}
