package com.example.jay.myapplication.utils;

import com.example.jay.myapplication.net.ApiHelper;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;

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

    public static <T> ArrayList<T> jsonParseToList(String result, Class<T> clazz) {//Gson 解析
        ArrayList<T> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                T entity = gson.fromJson(data.optJSONObject(i).toString(), clazz);
//                detail.add(entity);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }
}
