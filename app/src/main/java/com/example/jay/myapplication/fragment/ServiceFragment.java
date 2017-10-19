package com.example.jay.myapplication.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.databinding.FrgmentSevicehallBinding;

/**
 * Created by jay on 2017/10/19
 */

public class ServiceFragment extends BaseFragment {
    private FrgmentSevicehallBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.frgment_sevicehall, container, false);
        initView();
        return mBinding.getRoot();
    }

    private void initView() {
    }
}
