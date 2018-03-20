package com.example.jay.myapplication.ui.servicerecommenddetails.adapter.caselist;

import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.example.jay.myapplication.ui.servicerecommenddetails.adapter.vm.CaseListVM;
import com.example.jay.myapplication.utils.CollectionUtil;
import com.wangjie.seizerecyclerview.BaseSeizeAdapter;
import com.wangjie.seizerecyclerview.BaseViewHolder;

import java.util.List;

/**
 * author:hll
 * time:2018/3/20
 */

public class CaseListSeizeAdapter extends BaseSeizeAdapter {
    private List<CaseListVM> list;

    public List<CaseListVM> getList() {
        return list;
    }

    public void setList(List<CaseListVM> list) {
        this.list = list;
    }

    @Override
    public int getSourceItemViewType(int subSourcePosition) {
        return list.get(subSourcePosition).getViewType();
    }

    @Nullable
    @Override
    public BaseViewHolder onCreateTypeViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case CaseListVM.CASE_LIST:
                return new CaseListSeizeViewHolder(parent, this);
        }
        return null;
    }

    @Override
    public Object getItem(int subSourcePosition) {
        return list.get(subSourcePosition);
    }

    @Override
    public int getSourceItemCount() {
        return CollectionUtil.isEmpty(list) ? 0 : list.size();
    }
}
