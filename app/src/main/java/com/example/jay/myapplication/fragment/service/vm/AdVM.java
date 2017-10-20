package com.example.jay.myapplication.fragment.service.vm;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.jay.myapplication.bean.AdBean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/20
 */

public class AdVM extends VM<AdBean> implements Serializable {
    public static final int TYPE_AD = 10;

    public AdVM(@NonNull AdBean model) {
        super(model);
    }

    @Override
    public int getViewType() {
        return TYPE_AD;
    }

    public String getPic() {
        String pic = getModel().getPic();
        if (!TextUtils.isEmpty(pic)) {
            return pic;
        } else {
            return "";
        }
    }

    public String getContent() {
        String content = getModel().getContent();
        if (!TextUtils.isEmpty(content)) {
            return content;
        } else {
            return "";
        }
    }
}
