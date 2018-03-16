package com.example.jay.myapplication.fragment.mymsg.fragment.adapter.tab1;

import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.example.jay.myapplication.bean.MyMsgTab1Bean;
import com.example.jay.myapplication.utils.CollectionUtil;
import com.wangjie.seizerecyclerview.BaseSeizeAdapter;
import com.wangjie.seizerecyclerview.BaseViewHolder;

import java.util.List;

/**
 * author:hll
 * time:2018/3/16
 */

public class Tab1SeizeAdapter extends BaseSeizeAdapter {
    private List<MyMsgTab1Bean> list;
    private OnTab1SeizeAdapterListener onTab1SeizeAdapterListener;

    public interface OnTab1SeizeAdapterListener {
        void onTab1Click(int position);
    }

    public OnTab1SeizeAdapterListener getOnTab1SeizeAdapterListener() {
        return onTab1SeizeAdapterListener;
    }

    public void setOnTab1SeizeAdapterListener(OnTab1SeizeAdapterListener onTab1SeizeAdapterListener) {
        this.onTab1SeizeAdapterListener = onTab1SeizeAdapterListener;
    }

    public void setList(List<MyMsgTab1Bean> list) {
        this.list = list;
    }

    public List<MyMsgTab1Bean> getList() {
        return list;
    }

    @Nullable
    @Override
    public BaseViewHolder onCreateTypeViewHolder(ViewGroup parent, int viewType) {
        return new Tab1SeizeViewHolder(parent, this);
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
