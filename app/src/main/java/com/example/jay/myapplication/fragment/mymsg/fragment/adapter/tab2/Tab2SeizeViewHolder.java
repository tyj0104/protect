package com.example.jay.myapplication.fragment.mymsg.fragment.adapter.tab2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.bean.MyMsgTab2Bean;
import com.example.jay.myapplication.utils.CollectionUtil;
import com.wangjie.seizerecyclerview.BaseViewHolder;
import com.wangjie.seizerecyclerview.SeizePosition;

import java.util.List;

/**
 * author:hll
 * time:2018/3/16
 */

public class Tab2SeizeViewHolder extends BaseViewHolder implements View.OnClickListener {

    private final Tab2SeizeAdapter tab2SeizeAdapter;
    private final TextView projectTv;
    private final TextView nameTv;
    private final TextView tiemTv;
    private final ImageView picIv;
    private final TextView okTv;
    private int position;

    Tab2SeizeViewHolder(ViewGroup parent, Tab2SeizeAdapter tab2SeizeAdapter) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mymsg_tab2, parent, false));
        this.tab2SeizeAdapter = tab2SeizeAdapter;
        RelativeLayout view = (RelativeLayout) itemView.findViewById(R.id.item_mymsg_tab2_view);
        projectTv = (TextView) itemView.findViewById(R.id.item_mymsg_tab2_project_tv);
        nameTv = (TextView) itemView.findViewById(R.id.item_mymsg_tab2_name_tv);
        tiemTv = (TextView) itemView.findViewById(R.id.item_mymsg_tab2_time_tv);
        okTv = (TextView) itemView.findViewById(R.id.item_mymsg_tab2_ok_tv);
        picIv = (ImageView) itemView.findViewById(R.id.item_mymsg_tab2_pic_iv);
        view.setOnClickListener(this);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, SeizePosition seizePosition) {
        position = seizePosition.getSubSourcePosition();
        List<MyMsgTab2Bean> list = tab2SeizeAdapter.getList();
        if (CollectionUtil.isEmpty(list)) {
            return;
        }
        MyMsgTab2Bean myMsgTab2Bean = list.get(position);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_mymsg_tab2_view:
                Tab2SeizeAdapter.OnTab2SeizeAdapterListener onTab2SeizeAdapterListener = tab2SeizeAdapter.getOnTab2SeizeAdapterListener();
                if (onTab2SeizeAdapterListener != null) {
                    onTab2SeizeAdapterListener.onTab2Click(position);
                }
                break;
            default:
                break;
        }
    }
}
