package com.example.jay.myapplication.fragment.mymsg.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.base.adapter.XiaoErBaseSeizeAdapter;
import com.example.jay.myapplication.base.fragment.BaseFragment;
import com.example.jay.myapplication.bean.MyMsgTab2Bean;
import com.example.jay.myapplication.databinding.FragmentMsgTab2Binding;
import com.example.jay.myapplication.fragment.mymsg.fragment.adapter.tab2.Tab2SeizeAdapter;
import com.example.jay.myapplication.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * author:hll
 * time:2018/3/15
 */

public class Tab2Fragment extends BaseFragment implements Tab2SeizeAdapter.OnTab2SeizeAdapterListener {
    private String fragmentName = "服务商@我";
    private FragmentMsgTab2Binding mBinding;
    private Tab2SeizeAdapter tab2SeizeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_msg_tab2, container, false);
        initView();
        initData();
        return mBinding.getRoot();
    }

    private void initView() {
        RecyclerView rv = (RecyclerView) mBinding.getRoot().findViewById(R.id.fragment_mymsg_table2_rv);
        XiaoErBaseSeizeAdapter adapter = new XiaoErBaseSeizeAdapter();
        tab2SeizeAdapter = new Tab2SeizeAdapter();
        adapter.setSeizeAdapters(tab2SeizeAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
        tab2SeizeAdapter.setOnTab2SeizeAdapterListener(this);
    }

    private void initData() {
        List<MyMsgTab2Bean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyMsgTab2Bean myMsgTab2Bean = new MyMsgTab2Bean();
            list.add(myMsgTab2Bean);
        }
        tab2SeizeAdapter.setList(list);
        tab2SeizeAdapter.notifyDataSetChanged();
    }

    public String getFragmentName() {
        return fragmentName;
    }

    public void setFragmentName(String fragmentName) {
        this.fragmentName = fragmentName;
    }

    @Override
    public void onTab2Click(int position) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((MainActivity) activity).showToast(getContext(), fragmentName + position);
        }
    }
}
