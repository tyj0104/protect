package com.example.jay.myapplication.fragment.mymsg.fragment.adapter.tab1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.bean.MyMsgTab1Bean;
import com.example.jay.myapplication.utils.CollectionUtil;
import com.wangjie.seizerecyclerview.BaseViewHolder;
import com.wangjie.seizerecyclerview.SeizePosition;

import java.util.List;

/**
 * author:hll
 * time:2018/3/16
 */

class Tab1SeizeViewHolder extends BaseViewHolder implements View.OnClickListener {

    private final Tab1SeizeAdapter tab1SeizeAdapter;
    private final TextView projectTv;
    private final TextView nameTv;
    private final TextView tiemTv;
    private final ImageView picIv;
    private final TextView okTv;
    private int position;

    Tab1SeizeViewHolder(ViewGroup parent, Tab1SeizeAdapter tab1SeizeAdapter) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mymsg_tab1, parent, false));
        this.tab1SeizeAdapter = tab1SeizeAdapter;
        RelativeLayout view = (RelativeLayout) itemView.findViewById(R.id.item_mymsg_tab1_view);
        projectTv = (TextView) itemView.findViewById(R.id.item_mymsg_tab1_project_tv);
        nameTv = (TextView) itemView.findViewById(R.id.item_mymsg_tab1_name_tv);
        tiemTv = (TextView) itemView.findViewById(R.id.item_mymsg_tab1_time_tv);
        okTv = (TextView) itemView.findViewById(R.id.item_mymsg_tab1_ok_tv);
        picIv = (ImageView) itemView.findViewById(R.id.item_mymsg_tab1_pic_iv);
        view.setOnClickListener(this);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, SeizePosition seizePosition) {
        position = seizePosition.getSubSourcePosition();
        List<MyMsgTab1Bean> list = tab1SeizeAdapter.getList();
        if (CollectionUtil.isEmpty(list)) {
            return;
        }
        MyMsgTab1Bean myMsgTab1Bean = list.get(position);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_mymsg_tab1_view:
                Tab1SeizeAdapter.OnTab1SeizeAdapterListener onTab1SeizeAdapterListener = tab1SeizeAdapter.getOnTab1SeizeAdapterListener();
                if (onTab1SeizeAdapterListener != null) {
                    onTab1SeizeAdapterListener.onTab1Click(position);
                }
                break;
            default:
                break;
        }
    }
}
