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
import com.example.jay.myapplication.bean.MyMsgTab1Bean;
import com.example.jay.myapplication.databinding.FragmentMsgTab1Binding;
import com.example.jay.myapplication.fragment.mymsg.fragment.adapter.tab1.Tab1SeizeAdapter;
import com.example.jay.myapplication.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * author:hll
 * time:2018/3/15
 */

public class Tab1Fragment extends BaseFragment implements Tab1SeizeAdapter.OnTab1SeizeAdapterListener {
    private String fragmentName = "我发送的意向";
    private FragmentMsgTab1Binding mBinding;
    private Tab1SeizeAdapter tab1SeizeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_msg_tab1, container, false);
        initView();
        initData();
        return mBinding.getRoot();
    }

    private void initView() {
        RecyclerView rv = (RecyclerView) mBinding.getRoot().findViewById(R.id.fragment_mymsg_table1_rv);
        XiaoErBaseSeizeAdapter adapter = new XiaoErBaseSeizeAdapter();
        tab1SeizeAdapter = new Tab1SeizeAdapter();
        adapter.setSeizeAdapters(tab1SeizeAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
        tab1SeizeAdapter.setOnTab1SeizeAdapterListener(this);
    }

    private void initData() {
        List<MyMsgTab1Bean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyMsgTab1Bean myMsgTab1Bean = new MyMsgTab1Bean();
            list.add(myMsgTab1Bean);
        }
        tab1SeizeAdapter.setList(list);
        tab1SeizeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTab1Click(int position) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((MainActivity) activity).showToast(getContext(), fragmentName + position);
        }
    }

    public String getFragmentName() {
        return fragmentName;
    }

    public void setFragmentName(String fragmentName) {
        this.fragmentName = fragmentName;
    }
}
