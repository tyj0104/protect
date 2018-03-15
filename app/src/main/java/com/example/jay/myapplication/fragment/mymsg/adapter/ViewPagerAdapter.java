package com.example.jay.myapplication.fragment.mymsg.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.jay.myapplication.base.fragment.BaseFragment;
import com.example.jay.myapplication.utils.CollectionUtil;

import java.util.List;

/**
 * author:hll
 * time:2018/3/15
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> list;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return CollectionUtil.isEmpty(list) ? 0 : list.size();
    }

    public void setList(List<BaseFragment> list) {
        this.list = list;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getFragmentName();
    }
}
