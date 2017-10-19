package com.example.jay.myapplication.utils;

import com.example.jay.myapplication.net.ApiHelper;
import com.google.gson.Gson;

import static android.text.TextUtils.isEmpty;

/**
 * Created by Administrator on 2017/10/19
 */

public class JsonUtil {

    public static <T> T fromJson(Object o, Class<T> clazz) {
        String json = ApiHelper.getGson().toJson(o);
        if (isEmpty(json)) {
            return null;
        }
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, clazz);
        } catch (Exception ex) {
            return null;
        }
    }

}
