package com.example.jay.myapplication.fragment.service;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.bean.AdBean;
import com.example.jay.myapplication.databinding.FrgmentSevicehallBinding;
import com.example.jay.myapplication.fragment.BaseFragment;
import com.example.jay.myapplication.fragment.service.adapter.ServiceHallAdapter;
import com.example.jay.myapplication.fragment.service.adapter.ad.AdSeizeAdapter;
import com.example.jay.myapplication.fragment.service.adapter.recommend.RecommendSeizeAdapter;
import com.example.jay.myapplication.fragment.service.adapter.successfulcase.SuccessfulCaseSeizeAdapter;
import com.example.jay.myapplication.fragment.service.vm.AdVM;
import com.example.jay.myapplication.ui.main.MainActivity;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jay on 2017/10/19
 */

public class ServiceFragment extends BaseFragment implements AdSeizeAdapter.OnAdSeizeAdapterListener {
    private FrgmentSevicehallBinding mBinding;
    private AdSeizeAdapter adSeizeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.frgment_sevicehall, container, false);
        initView();
        initData();
        return mBinding.getRoot();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) mBinding.getRoot().findViewById(R.id.fragment_service_hall_rl);


        ServiceHallAdapter adapter = new ServiceHallAdapter();
        adSeizeAdapter = new AdSeizeAdapter();
        RecommendSeizeAdapter recommendSeizeAdapter = new RecommendSeizeAdapter();
        SuccessfulCaseSeizeAdapter successfulCaseSeizeAdapter = new SuccessfulCaseSeizeAdapter();
        adapter.setSeizeAdapters(adSeizeAdapter, recommendSeizeAdapter, successfulCaseSeizeAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        AdBean adBean = new AdBean();
        adBean.setContent("我不是好人，我要做一个坏人，老田你看着办，是死，是活，你一句话，我去解决了小杜");
        Flowable.just(adBean)
                .subscribeOn(Schedulers.io())
                .map(AdVM::new)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adVM -> {
                    adSeizeAdapter.setAdVM(adVM);
                    adSeizeAdapter.setOnAdSeizeAdapterListener(this);
                    adSeizeAdapter.notifyDataSetChanged();
                });
    }

    @Override
    public void onAdClick() {
        MainActivity activity = (MainActivity) getActivity();
        activity.showToast(getContext(), "我点击了广告栏");
    }
}
