package com.example.jay.myapplication.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/20
 */

public class AdBean implements Serializable {
    private String pic;
    private String content;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
