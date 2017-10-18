package com.example.jay.myapplication.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author TianYingJie
 * @date 2017/10/17
 */

public class ApiHelper {
   public static String  baseUrl = "http://106.14.123.217:8089/";
    public static  Api  getApi(){
        return SingletonHolder.instance;
    }

    public  static Gson getGson(){
     return  SingletonHolder.sGson;
    }


    private  static class SingletonHolder{
        private  static  Gson sGson = creatGson();
        private  static  Api instance = creatApi();

    }
    private  static  Api creatApi(){
        return  new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(new OkHttpClient.Builder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30,TimeUnit.SECONDS)
                        .readTimeout(30,TimeUnit.SECONDS)
                        .retryOnConnectionFailure(true)
                        .build()
                )
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);
    }
    private static final  String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static Gson creatGson(){
        return new GsonBuilder()
                .setLenient()
                .serializeNulls()
                .setPrettyPrinting()
                .setDateFormat(dateFormat)
                .create();
    }
}
