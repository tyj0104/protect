package com.example.jay.myapplication.ui.servicerecommenddetails.adapter.caselist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jay.myapplication.R;
import com.wangjie.seizerecyclerview.BaseViewHolder;
import com.wangjie.seizerecyclerview.SeizePosition;

/**
 * author:hll
 * time:2018/3/20
 */

public class CaseListSeizeViewHolder extends BaseViewHolder {
    private int position;
    private final TextView nameTv;
    private final TextView timeTv;
    private final TextView projectNameTv;
    private final TextView companyNameTv;
    private final CaseListSeizeAdapter caseListSeizeAdapter;

    public CaseListSeizeViewHolder(ViewGroup parent, CaseListSeizeAdapter caseListSeizeAdapter) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend_detail_case_list, parent, false));
        this.caseListSeizeAdapter = caseListSeizeAdapter;
        RelativeLayout viewRl = (RelativeLayout) itemView.findViewById(R.id.item_recommend_detail_case_list_view);
        nameTv = (TextView) itemView.findViewById(R.id.item_successful_case_name_tv);
        projectNameTv = (TextView) itemView.findViewById(R.id.item_successful_case_project_name_tv);
        timeTv = (TextView) itemView.findViewById(R.id.item_successful_case_time_tv);
        companyNameTv = (TextView) itemView.findViewById(R.id.item_successful_case_company_name_tv);
//        viewRl.setOnClickListener(this);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, SeizePosition seizePosition) {
//        position = seizePosition.getSubSourcePosition();
    }

}
