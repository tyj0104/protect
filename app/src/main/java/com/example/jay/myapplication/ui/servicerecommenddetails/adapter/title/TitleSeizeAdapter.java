package com.example.jay.myapplication.ui.servicerecommenddetails.adapter.title;

import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.example.jay.myapplication.ui.servicerecommenddetails.adapter.vm.TitleVM;
import com.wangjie.seizerecyclerview.BaseSeizeAdapter;
import com.wangjie.seizerecyclerview.BaseViewHolder;

/**
 * author:hll
 * time:2018/3/20
 */

public class TitleSeizeAdapter extends BaseSeizeAdapter {
    private TitleVM titleVM;

    public TitleVM getTitleVM() {
        return titleVM;
    }

    public void setTitleVM(TitleVM titleVM) {
        this.titleVM = titleVM;
    }

    @Override
    public int getSourceItemViewType(int subSourcePosition) {
        return TitleVM.TITLE;
    }

    @Nullable
    @Override
    public BaseViewHolder onCreateTypeViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TitleVM.TITLE:
                return new TitleSeizeViewHolder(parent, this);
        }
        return null;
    }

    @Override
    public Object getItem(int i) {
        return titleVM;
    }

    @Override
    public int getSourceItemCount() {
        return titleVM == null ? 0 : 1;
    }
}
