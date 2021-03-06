package com.example.jay.myapplication.fragment.service.adapter.successfulcase;

import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.example.jay.myapplication.fragment.service.vm.SuccessfulCaseVM;
import com.wangjie.seizerecyclerview.BaseSeizeAdapter;
import com.wangjie.seizerecyclerview.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/20
 */

public class SuccessfulCaseSeizeAdapter extends BaseSeizeAdapter {
    private boolean xuQiuFang;
    private List<SuccessfulCaseVM> list = new ArrayList<>();
    private OnSuccessfulCaseSeizeAdapterListener onSuccessfulCaseSeizeAdapter;

    public void setXuQiuFang(boolean xuQiuFang) {
        this.xuQiuFang = xuQiuFang;
    }

    boolean getXuQiuFang() {
        return xuQiuFang;
    }

    public interface OnSuccessfulCaseSeizeAdapterListener {
        void onSuccessfulCaseClick(int position);
    }

    OnSuccessfulCaseSeizeAdapterListener getOnSuccessfulCaseSeizeAdapter() {
        return onSuccessfulCaseSeizeAdapter;
    }

    public void setOnSuccessfulCaseSeizeAdapter(OnSuccessfulCaseSeizeAdapterListener onSuccessfulCaseSeizeAdapter) {
        this.onSuccessfulCaseSeizeAdapter = onSuccessfulCaseSeizeAdapter;
    }

    List<SuccessfulCaseVM> getList() {
        return list;
    }

    public void setList(List<SuccessfulCaseVM> list) {
        this.list = list;
    }

    @Override
    public int getSourceItemViewType(int subSourcePosition) {
        return list.get(subSourcePosition).getViewType();
    }

    @Nullable
    @Override
    public BaseViewHolder onCreateTypeViewHolder(ViewGroup parent, int type) {
        switch (type) {
            case SuccessfulCaseVM.TYPE_SUCCESSFUL_CASE:
                return new SuccessfulCaseSeizeAdapterViewHolder(this, parent);
            default:
                return null;
        }
    }

    @Override
    public Object getItem(int subSourcePosition) {
        return list.get(subSourcePosition);
    }

    @Override
    public int getSourceItemCount() {
        return list.size();
    }
}
