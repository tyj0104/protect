package com.example.jay.myapplication.ui.servicerecommenddetails.adapter.title;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jay.myapplication.R;
import com.wangjie.seizerecyclerview.BaseViewHolder;
import com.wangjie.seizerecyclerview.SeizePosition;

/**
 * author:hll
 * time:2018/3/20
 */

public class TitleSeizeViewHolder extends BaseViewHolder {
    public TitleSeizeViewHolder(ViewGroup parent, TitleSeizeAdapter titleSeizeAdapter) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend_detail_title, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, SeizePosition seizePosition) {

    }
}
