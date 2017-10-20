package com.example.jay.myapplication.fragment.service.adapter.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jay.myapplication.R;
import com.example.jay.myapplication.fragment.service.vm.AdVM;
import com.example.jay.myapplication.utils.ResUtil;
import com.wangjie.seizerecyclerview.BaseViewHolder;
import com.wangjie.seizerecyclerview.SeizePosition;

/**
 * Created by Administrator on 2017/10/20
 */

public class AdSeizeViewHolder extends BaseViewHolder implements View.OnClickListener {
    private final AdSeizeAdapter adSeizeAdapter;
    private final ImageView pic;
    private final TextView content;
    private final Context context;
    private final RelativeLayout view;

    public AdSeizeViewHolder(AdSeizeAdapter adSeizeAdapter, ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service_ad, parent, false));
        this.adSeizeAdapter = adSeizeAdapter;
        context = parent.getContext();
        content = (TextView) itemView.findViewById(R.id.item_service_ad_tv);
        pic = (ImageView) itemView.findViewById(R.id.item_service_ad_iv);
        view = (RelativeLayout) itemView.findViewById(R.id.item_service_ad_view);
        view.setOnClickListener(this);
        pic.setVisibility(View.GONE);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, SeizePosition seizePosition) {
        if (!adSeizeAdapter.getXuQiuFang()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT, ResUtil.dip2px(context, 180));
            int px = ResUtil.dip2px(context, 20);
            layoutParams.setMargins(px, px, px, 0);
            view.setLayoutParams(layoutParams);
        }
        AdVM adVM = adSeizeAdapter.getAdVM();
        Glide.with(context).load(adVM.getPic()).into(pic);
        content.setText(adVM.getContent());
    }

    @Override
    public void onClick(View v) {
        AdSeizeAdapter.OnAdSeizeAdapterListener onAdSeizeAdapterListener = adSeizeAdapter.getOnAdSeizeAdapterListener();
        switch (v.getId()) {
            case R.id.item_service_ad_view:
                if (onAdSeizeAdapterListener != null) {
                    onAdSeizeAdapterListener.onAdClick();
                }
                break;
            default:
                break;
        }
    }
}
