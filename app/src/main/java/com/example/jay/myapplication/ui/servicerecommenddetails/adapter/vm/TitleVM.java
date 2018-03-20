package com.example.jay.myapplication.ui.servicerecommenddetails.adapter.vm;

import android.support.annotation.NonNull;

import com.example.jay.myapplication.bean.RecommendDetailTitleBean;
import com.example.jay.myapplication.fragment.service.vm.VM;

/**
 * author:hll
 * time:2018/3/20
 */

public class TitleVM extends VM<RecommendDetailTitleBean> {
    public static final int TITLE = 10;

    public TitleVM(@NonNull RecommendDetailTitleBean model) {
        super(model);
    }

    @Override
    public int getViewType() {
        return super.getViewType();
    }
}
