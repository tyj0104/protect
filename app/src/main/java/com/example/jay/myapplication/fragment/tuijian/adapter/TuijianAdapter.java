package com.example.jay.myapplication.fragment.tuijian.adapter;

import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.example.jay.myapplication.fragment.tuijian.vm.TuiJianVm;
import com.wangjie.seizerecyclerview.BaseSeizeAdapter;
import com.wangjie.seizerecyclerview.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay on 2018/3/9.
 */

public class TuijianAdapter extends BaseSeizeAdapter {
    private List<TuiJianVm> list = new ArrayList<>();
    private TuiJianAdapterListener mTuiJianAdapterListener;

    public interface TuiJianAdapterListener {
        void onTuijianClick(int position);
    }

    public TuijianAdapter.TuiJianAdapterListener getTuiJianAdapterListener() {
        return mTuiJianAdapterListener;
    }

    public void TuiJianAdapterListener(TuijianAdapter.TuiJianAdapterListener listener) {
        this.mTuiJianAdapterListener = listener;
    }

    public List<TuiJianVm> getList() {
        return this.list;
    }

    public void setList(List<TuiJianVm> list) {
        this.list = list;
    }

    @Nullable
    @Override
    public BaseViewHolder onCreateTypeViewHolder(ViewGroup viewGroup, int type) {
        switch (type) {
            case TuiJianVm.TYPE_TUIJIAN:
                return new TuiJianViewHolder(this, viewGroup);
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

    @Override
    public int getSourceItemViewType(int subSourcePosition) {
        return list.get(subSourcePosition).getViewType();

    }
}


