package com.example.jay.myapplication.fragment.mymsg;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.base.fragment.BaseFragment;
import com.example.jay.myapplication.databinding.FrgmentMsgBinding;
import com.example.jay.myapplication.fragment.mymsg.adapter.ViewPagerAdapter;
import com.example.jay.myapplication.fragment.mymsg.fragment.Tab1Fragment;
import com.example.jay.myapplication.fragment.mymsg.fragment.Tab2Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay on 2017/10/19
 */

public class MyMsgFragment extends BaseFragment {

    private FrgmentMsgBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.frgment_msg, container, false);
        initView();
        return mBinding.getRoot();
    }

    private void initView() {
        //实例化
        ViewPager viewPager = (ViewPager) mBinding.getRoot().findViewById(R.id.fragment_mymsg_viewpager);
        TabLayout tabLayout = (TabLayout) mBinding.getRoot().findViewById(R.id.fragment_mymsg_table);
        //tab的字体选择器,默认黑色,选择时红色
        tabLayout.setTabTextColors(Color.BLACK, Color.BLUE);
        //tab的下划线颜色,默认是粉红色
        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);

        List<BaseFragment> list = initData();
        //ViewPager的适配器
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.setList(list);
        viewPager.setAdapter(adapter);
        //绑定
        tabLayout.setupWithViewPager(viewPager);
    }

    private List<BaseFragment> initData() {
        //页面，数据源
        List<BaseFragment> list = new ArrayList<>();
        list.add(new Tab1Fragment());
        list.add(new Tab2Fragment());
        return list;
    }
}
