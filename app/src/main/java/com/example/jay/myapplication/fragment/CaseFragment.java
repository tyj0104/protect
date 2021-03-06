package com.example.jay.myapplication.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.base.fragment.BaseFragment;
import com.example.jay.myapplication.databinding.FrgmentCaseBinding;

/**
 * Created by jay on 2017/10/19.
 */

public class CaseFragment extends BaseFragment {

    private FrgmentCaseBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.frgment_case, container, false);
        return mBinding.getRoot();
    }
}
