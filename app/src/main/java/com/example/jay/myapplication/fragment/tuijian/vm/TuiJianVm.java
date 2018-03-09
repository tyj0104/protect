package com.example.jay.myapplication.fragment.tuijian.vm;

import android.support.annotation.NonNull;

import com.example.jay.myapplication.fragment.service.vm.VM;
import com.example.jay.myapplication.fragment.tuijian.adapter.TuiJianBean;

/**
 * Created by jay on 2018/3/9.
 */

public class TuiJianVm extends VM<TuiJianBean> {
    public static final int TYPE_TUIJIAN = 20;
    public TuiJianVm(@NonNull TuiJianBean model) {
        super(model);
    }

    @Override
    public int getViewType() {
        return TYPE_TUIJIAN;
    }
}
