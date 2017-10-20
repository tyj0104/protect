package com.example.jay.myapplication.fragment.service.vm;

import android.support.annotation.NonNull;

import com.example.jay.myapplication.bean.SuccessfulCaseBean;

/**
 * Created by Administrator on 2017/10/20
 */

public class SuccessfulCaseVM extends VM<SuccessfulCaseBean> {
    public static final int TYPE_SUCCESSFUL_CASE = 30;

    public SuccessfulCaseVM(@NonNull SuccessfulCaseBean model) {
        super(model);
    }

    public int getViewType() {
        return TYPE_SUCCESSFUL_CASE;
    }
}
