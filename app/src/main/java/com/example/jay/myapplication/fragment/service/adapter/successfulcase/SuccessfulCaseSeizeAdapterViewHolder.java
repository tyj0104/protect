package com.example.jay.myapplication.fragment.service.adapter.successfulcase;

import android.view.LayoutInflater;
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

    public SuccessfulCaseSeizeAdapterViewHolder(SuccessfulCaseSeizeAdapter successfulCaseSeizeAdapter, ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service_successful_case, parent, false));
        this.successfulCaseSeizeAdapter = successfulCaseSeizeAdapter;

        tv1 = (TextView) itemView.findViewById(R.id.item_successful_case_01_tv);
        tv2 = (TextView) itemView.findViewById(R.id.item_successful_case_02_tv);
        tv3 = (TextView) itemView.findViewById(R.id.item_successful_case_03_tv);

    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, SeizePosition seizePosition) {
        int position = seizePosition.getSubSourcePosition();
        SuccessfulCaseVM successfulCaseVM = successfulCaseSeizeAdapter.getList().get(position);
        SuccessfulCaseBean model = successfulCaseVM.getModel();

        tv1.setText(model.getTv1());
        tv2.setText("与" + model.getTv2() + "");
        tv3.setText(model.getTv3());
    }
}
