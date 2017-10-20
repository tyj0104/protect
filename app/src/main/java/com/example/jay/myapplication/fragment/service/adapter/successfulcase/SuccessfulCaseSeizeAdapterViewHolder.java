package com.example.jay.myapplication.fragment.service.adapter.successfulcase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.bean.SuccessfulCaseBean;
import com.example.jay.myapplication.fragment.service.vm.SuccessfulCaseVM;
import com.wangjie.seizerecyclerview.BaseViewHolder;
import com.wangjie.seizerecyclerview.SeizePosition;

/**
 * Created by Administrator on 2017/10/20
 */

public class SuccessfulCaseSeizeAdapterViewHolder extends BaseViewHolder {
    private final SuccessfulCaseSeizeAdapter successfulCaseSeizeAdapter;
    private final TextView tv1;
    private final TextView tv2;
    private final TextView tv3;
    private final TextView tv4;
    private final TextView tv6;
    private final TextView tv5;

    public SuccessfulCaseSeizeAdapterViewHolder(SuccessfulCaseSeizeAdapter successfulCaseSeizeAdapter, ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service_successful_case, parent, false));
        this.successfulCaseSeizeAdapter = successfulCaseSeizeAdapter;

        tv1 = (TextView) itemView.findViewById(R.id.item_successful_case_01_tv);
        tv2 = (TextView) itemView.findViewById(R.id.item_successful_case_02_tv);
        tv3 = (TextView) itemView.findViewById(R.id.item_successful_case_03_tv);
        tv4 = (TextView) itemView.findViewById(R.id.item_successful_case_04_tv);
        tv5 = (TextView) itemView.findViewById(R.id.item_successful_case_05_tv);
        tv6 = (TextView) itemView.findViewById(R.id.item_successful_case_06_tv);

    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, SeizePosition seizePosition) {
        int position = seizePosition.getSubSourcePosition();
        SuccessfulCaseVM successfulCaseVM = successfulCaseSeizeAdapter.getList().get(position);
        boolean xuQiuFang = successfulCaseSeizeAdapter.getXuQiuFang();
        SuccessfulCaseBean model = successfulCaseVM.getModel();

        tv1.setText(model.getTv1());
        if (!xuQiuFang) {
            tv2.setText(model.getTv2());
            tv3.setText(model.getTv3());
            tv4.setVisibility(View.VISIBLE);
            tv4.setText(model.getTv4());
            tv5.setText("已对接" + model.getTv5() + "");
            tv6.setVisibility(View.VISIBLE);
            tv6.setText("已关注" + model.getTv6() + "");
        } else {
            tv2.setText("与" + model.getTv2() + "");
            tv3.setText(model.getTv3());
            tv5.setText("已完成");
            tv4.setVisibility(View.GONE);
            tv6.setVisibility(View.GONE);
        }
    }
}
