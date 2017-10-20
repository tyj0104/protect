package com.example.jay.myapplication.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/20
 */
public class RecommendBean implements Serializable{
    private String pic;
    private String name;
    private String desc;
    private String star;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }
}
