package com.example.jay.myapplication.fragment.service.adapter.recommend;

import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.example.jay.myapplication.fragment.service.vm.RecommendVM;
import com.wangjie.seizerecyclerview.BaseSeizeAdapter;
import com.wangjie.seizerecyclerview.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/20
 */

public class RecommendSeizeAdapter extends BaseSeizeAdapter {
    private List<RecommendVM> list = new ArrayList<>();
    private OnRecommendSeizeAdapterListener onRecommendSeizeAdapterListener;

    public interface OnRecommendSeizeAdapterListener {
        void onRecommendClick();
    }

    public OnRecommendSeizeAdapterListener getOnRecommendSeizeAdapterListener() {
        return onRecommendSeizeAdapterListener;
    }

    public void setOnRecommendSeizeAdapterListener(OnRecommendSeizeAdapterListener onRecommendSeizeAdapterListener) {
        this.onRecommendSeizeAdapterListener = onRecommendSeizeAdapterListener;
    }

    public List<RecommendVM> getList() {
        return list;
    }

    public void setList(List<RecommendVM> list) {
        this.list = list;
    }

    @Nullable
    @Override
    public BaseViewHolder onCreateTypeViewHolder(ViewGroup parent, int type) {
        switch (type) {
            case RecommendVM.TYPE_RECOMMEND:
                return new RecommendSeizeAdapterViewHolder(this, parent);
            default:
                return null;
        }
    }

    @Override
    public int getSourceItemViewType(int subSourcePosition) {
        return list.get(subSourcePosition).getViewType();
    }

    @Override
    public Object getItem(int subSourcePosition) {
        return list.get(subSourcePosition);
    }

    @Override
    public int getSourceItemCount() {
        return list.size() > 5 ? 5 : list.size();
    }
}
