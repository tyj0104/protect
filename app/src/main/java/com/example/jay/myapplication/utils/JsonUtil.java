package com.example.jay.myapplication.utils;

import com.example.jay.myapplication.net.ApiHelper;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/10/19
 */

public class JsonUtil {

    public static <T> T fromJson(Object o, Class<T> clazz) {
        String s = ApiHelper.getGson().toJson(o);
        Gson gson = new Gson();
        return gson.fromJson(s, clazz);
    }

}
