package com.example.jay.myapplication.ui.servicerecommenddetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.base.activity.BaseActivity;
import com.example.jay.myapplication.base.adapter.XiaoErBaseSeizeAdapter;
import com.example.jay.myapplication.bean.RecommendDetailCaseListBean;
import com.example.jay.myapplication.databinding.ActivityRecommenddetailBinding;
import com.example.jay.myapplication.ui.servicerecommenddetails.adapter.caselist.CaseListSeizeAdapter;
import com.example.jay.myapplication.ui.servicerecommenddetails.adapter.title.TitleSeizeAdapter;
import com.example.jay.myapplication.ui.servicerecommenddetails.adapter.vm.CaseListVM;
import com.example.jay.myapplication.utils.ResUtil;
import com.example.jay.myapplication.widget.BackToolbar;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/26
 */

public class ServiceRecommendDetailActivity extends BaseActivity implements View.OnClickListener {

    private TitleSeizeAdapter titleSeizeAdapter;
    private ActivityRecommenddetailBinding binding;
    private CaseListSeizeAdapter caseListSeizeAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recommenddetail);
        initView();
        initData();
    }

    private void initView() {
        BackToolbar toolbar = (BackToolbar) binding.getRoot().findViewById(R.id.activity_recommend_detail_toolbar);
        TextView sendTv = (TextView) binding.getRoot().findViewById(R.id.activity_recommend_detail_send);
        RecyclerView recyclerView = (RecyclerView) binding.getRoot().findViewById(R.id.activity_recommend_detail_rlv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        XiaoErBaseSeizeAdapter xiaoErBaseSeizeAdapter = new XiaoErBaseSeizeAdapter();
        titleSeizeAdapter = new TitleSeizeAdapter();
        caseListSeizeAdapter = new CaseListSeizeAdapter();
        xiaoErBaseSeizeAdapter.setSeizeAdapters(titleSeizeAdapter, caseListSeizeAdapter);
        recyclerView.setAdapter(xiaoErBaseSeizeAdapter);

        toolbar.setOnBackListener(this::finish);
        sendTv.setOnClickListener(this);
    }

    private void initData() {
        showLoadingDialog(this, "加载中...");
        ArrayList<CaseListVM> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            RecommendDetailCaseListBean recommendDetailCaseListBean = new RecommendDetailCaseListBean();
            CaseListVM caseListVM = new CaseListVM(recommendDetailCaseListBean);
            list.add(caseListVM);
        }
        caseListSeizeAdapter.setList(list);
        TextView textView = new TextView(this);
        textView.setText("成功案例：6");
        textView.setTextColor(ResUtil.getColor(R.color.project_main_tv));
        textView.setTextSize(16);
        int i = ResUtil.dip2px(10);
        textView.setPadding(i, i, 0, 0);
        caseListSeizeAdapter.setHeader(textView);
        caseListSeizeAdapter.notifyDataSetChanged();
        cancelLoadingDialog(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_recommend_detail_send:
                showToast(this, "我点击了发送");
                break;
            default:
                break;
        }
    }
}
