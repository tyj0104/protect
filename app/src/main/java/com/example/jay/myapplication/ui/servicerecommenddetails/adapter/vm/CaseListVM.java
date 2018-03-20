package com.example.jay.myapplication.ui.servicerecommenddetails.adapter.vm;

import android.support.annotation.NonNull;

import com.example.jay.myapplication.bean.RecommendDetailCaseListBean;
import com.example.jay.myapplication.fragment.service.vm.VM;

/**
 * author:hll
 * time:2018/3/20
 */

public class CaseListVM extends VM<RecommendDetailCaseListBean> {
    public static final int CASE_LIST = 20;

    public CaseListVM(@NonNull RecommendDetailCaseListBean model) {
        super(model);
    }

    @Override
    public int getViewType() {
        return CASE_LIST;
    }
}
