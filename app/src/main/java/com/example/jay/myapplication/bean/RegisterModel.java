package com.example.jay.myapplication.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/10/18
 */

public class RegisterModel implements Serializable {

    private List<A01APPRegisterBean> A01_APP_Register;

    public List<A01APPRegisterBean> getA01_APP_Register() {
        return A01_APP_Register;
    }

    public void setA01_APP_Register(List<A01APPRegisterBean> A01_APP_Register) {
        this.A01_APP_Register = A01_APP_Register;
    }

    public static class A01APPRegisterBean implements Serializable{
        /**
         * session_id :
         * s_result : 0
         * error_desc : 璇ユ墜鏈哄彿宸插瓨鍦�,璇疯仈绯荤鐞嗗憳
         * login_id :
         * nickname :
         * ALI_ACCOUNT :
         * M_ACCOUNT :
         */

        private String session_id;
        private String s_result;
        private String error_desc;
        private String login_id;
        private String nickname;
        private String ALI_ACCOUNT;
        private String M_ACCOUNT;

        public String getSession_id() {
            return session_id;
        }

        public void setSession_id(String session_id) {
            this.session_id = session_id;
        }

        public String getS_result() {
            return s_result;
        }

        public void setS_result(String s_result) {
            this.s_result = s_result;
        }

        public String getError_desc() {
            return error_desc;
        }

        public void setError_desc(String error_desc) {
            this.error_desc = error_desc;
        }

        public String getLogin_id() {
            return login_id;
        }

        public void setLogin_id(String login_id) {
            this.login_id = login_id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getALI_ACCOUNT() {
            return ALI_ACCOUNT;
        }

        public void setALI_ACCOUNT(String ALI_ACCOUNT) {
            this.ALI_ACCOUNT = ALI_ACCOUNT;
        }

        public String getM_ACCOUNT() {
            return M_ACCOUNT;
        }

        public void setM_ACCOUNT(String M_ACCOUNT) {
            this.M_ACCOUNT = M_ACCOUNT;
        }
    }
}
