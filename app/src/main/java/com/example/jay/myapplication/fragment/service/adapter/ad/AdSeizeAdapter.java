package com.example.jay.myapplication.fragment.service.adapter.ad;

import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.example.jay.myapplication.fragment.service.vm.AdVM;
import com.wangjie.seizerecyclerview.BaseSeizeAdapter;
import com.wangjie.seizerecyclerview.BaseViewHolder;

/**
 * Created by Administrator on 2017/10/20
 */

public class AdSeizeAdapter extends BaseSeizeAdapter {

    private AdVM adVM;
    private OnAdSeizeAdapterListener onAdSeizeAdapterListener;

    public interface OnAdSeizeAdapterListener {
        void onAdClick();
    }

    public OnAdSeizeAdapterListener getOnAdSeizeAdapterListener() {
        return onAdSeizeAdapterListener;
    }

    public void setOnAdSeizeAdapterListener(OnAdSeizeAdapterListener onAdSeizeAdapterListener) {
        this.onAdSeizeAdapterListener = onAdSeizeAdapterListener;
    }

    public void setAdVM(AdVM adVM) {
        this.adVM = adVM;
    }

    public AdVM getAdVM() {
        return adVM;
    }

    @Override
    public int getSourceItemViewType(int subSourcePosition) {
        return adVM.getViewType();
    }

    @Nullable
    @Override
    public BaseViewHolder onCreateTypeViewHolder(ViewGroup parent, int type) {
        switch (type) {
            case AdVM.TYPE_AD:
                return new AdSeizeViewHolder(this, parent);
            default:
                return null;
        }
    }

    @Override
    public Object getItem(int i) {
        return adVM;
    }

    @Override
    public int getSourceItemCount() {
        return null == adVM ? 0 : 1;
    }
}
