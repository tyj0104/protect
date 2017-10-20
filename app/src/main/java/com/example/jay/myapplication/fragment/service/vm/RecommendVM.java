package com.example.jay.myapplication.fragment.service.vm;

import android.support.annotation.NonNull;

import com.example.jay.myapplication.bean.RecommendBean;

/**
 * Created by Administrator on 2017/10/20
 */

public class RecommendVM extends VM<RecommendBean> {
    public static final int TYPE_RECOMMEND = 20;

    public RecommendVM(@NonNull RecommendBean model) {
        super(model);
    }

    @Override
    public int getViewType() {
        return TYPE_RECOMMEND;
    }
}
