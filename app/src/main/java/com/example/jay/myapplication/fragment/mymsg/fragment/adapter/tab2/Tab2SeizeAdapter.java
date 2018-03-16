package com.example.jay.myapplication.fragment.mymsg.fragment.adapter.tab2;

import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.example.jay.myapplication.bean.MyMsgTab2Bean;
import com.example.jay.myapplication.utils.CollectionUtil;
import com.wangjie.seizerecyclerview.BaseSeizeAdapter;
import com.wangjie.seizerecyclerview.BaseViewHolder;

import java.util.List;

/**
 * author:hll
 * time:2018/3/16
 */

public class Tab2SeizeAdapter extends BaseSeizeAdapter {
    private List<MyMsgTab2Bean> list;
    private OnTab2SeizeAdapterListener onTab2SeizeAdapterListener;

    public interface OnTab2SeizeAdapterListener {
        void onTab2Click(int position);
    }

    OnTab2SeizeAdapterListener getOnTab2SeizeAdapterListener() {
        return onTab2SeizeAdapterListener;
    }

    public void setOnTab2SeizeAdapterListener(OnTab2SeizeAdapterListener onTab2SeizeAdapterListener) {
        this.onTab2SeizeAdapterListener = onTab2SeizeAdapterListener;
    }

    public void setList(List<MyMsgTab2Bean> list) {
        this.list = list;
    }

    public List<MyMsgTab2Bean> getList() {
        return list;
    }

    @Nullable
    @Override
    public BaseViewHolder onCreateTypeViewHolder(ViewGroup parent, int viewType) {
        return new Tab2SeizeViewHolder(parent, this);
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
