package com.example.jay.myapplication.fragment.tuijian;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.bean.UserInfo;
import com.example.jay.myapplication.databinding.FrgmentCaseBinding;
import com.example.jay.myapplication.databinding.FrgmentTuijianBinding;
import com.example.jay.myapplication.fragment.BaseFragment;
import com.example.jay.myapplication.fragment.service.adapter.successfulcase.SuccessfulCaseSeizeAdapter;
import com.example.jay.myapplication.ui.main.MainActivity;

/**
 * Created by jay on 2017/10/19.
 */

public class TuijianFragment extends BaseFragment {
    private FrgmentTuijianBinding mBinding;

    private MainActivity activity;

    private boolean xuQiuFang;

   private RecyclerView recll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.frgment_tuijian, container, false);
        initView();
        return mBinding.getRoot();
    }

    private void initView() {
        activity = (MainActivity) getActivity();
        xuQiuFang = UserInfo.getInstance().isXuQiuFang();
        recll = (RecyclerView) mBinding.getRoot().findViewById(R.id.fragment_tuijian_hall_rl);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recll.setLayoutManager(linearLayoutManager);
    }
}
