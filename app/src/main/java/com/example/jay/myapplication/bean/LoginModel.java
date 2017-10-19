package com.example.jay.myapplication.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/10/19
 */

public class LoginModel implements Serializable {

    private List<A01APPLoginBean> A01_APP_Login;

    public List<A01APPLoginBean> getA01_APP_Login() {
        return A01_APP_Login;
    }

    public void setA01_APP_Login(List<A01APPLoginBean> A01_APP_Login) {
        this.A01_APP_Login = A01_APP_Login;
    }

    public static class A01APPLoginBean {
        /**
         * session_id : 571DFFBC-EE9A-41B9-BFFD-59A337A6CD70
         * s_result : 1
         * error_desc :
         * login_id : aaa
         * nickname : ccc
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
