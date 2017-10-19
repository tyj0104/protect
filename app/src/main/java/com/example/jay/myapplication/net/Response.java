package com.example.jay.myapplication.net;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author TianYingjie
 * @date 2017/10/17
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    public static final int OK = 0;
    public static final int ERR = 1;
    public static final int ERR_NETWORK = -2;
    public static final int ERR_CONNECT = -3;
    public static final int ERR_CONNECT_TIMEOUT = -4;

    /*消息状态码*/
    private int code = ERR;
    /*消息文本内容*/
    private String message = "未知错误";

    /*通过异常来构造一个错误消息*/
    public Response(Throwable e) {
        e.printStackTrace();
        if (e instanceof com.jakewharton.retrofit2.adapter.rxjava2.HttpException) {
            this.code = ERR_NETWORK;
            this.message = "网络异常";
        } else if (e instanceof java.net

                .ConnectException || e.getCause() instanceof java.net

                .ConnectException) {
            this.code = ERR_CONNECT;
            this.message = "连接异常";
        } else if (e instanceof java.net

                .SocketTimeoutException) {
            this.code = ERR_CONNECT_TIMEOUT;
            this.message = "连接超时";
        } else {

        }

    }

    /**
     * 是否为正常返回
     */
    public final boolean isOK() {
        return code == OK;
    }

    /**
     * 检查返回值是否为OK
     */
    public static <T extends Response> T verify(T t) {
        if (t.isOK()) return t;
        throw new RuntimeException(t.toString());
    }

    @Override
    public String toString() {

        return ApiHelper.getGson().toJson(this);
    }
}

