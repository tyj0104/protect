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
import com.example.jay.myapplication.base.adapter.XiaoErBaseSeizeAdapter;
import com.example.jay.myapplication.bean.AdBean;
import com.example.jay.myapplication.bean.RecommendBean;
import com.example.jay.myapplication.bean.SuccessfulCaseBean;
import com.example.jay.myapplication.bean.UserInfo;
import com.example.jay.myapplication.base.fragment.BaseFragment;
import com.example.jay.myapplication.fragment.service.adapter.ad.AdSeizeAdapter;
import com.example.jay.myapplication.fragment.service.adapter.recommend.RecommendSeizeAdapter;
import com.example.jay.myapplication.fragment.service.adapter.successfulcase.SuccessfulCaseSeizeAdapter;
import com.example.jay.myapplication.fragment.service.vm.AdVM;
import com.example.jay.myapplication.fragment.service.vm.RecommendVM;
import com.example.jay.myapplication.fragment.service.vm.SuccessfulCaseVM;
import com.example.jay.myapplication.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jay on 2017/10/19
 */

public class ServiceFragment extends BaseFragment implements AdSeizeAdapter.OnAdSeizeAdapterListener, RecommendSeizeAdapter.OnRecommendSeizeAdapterListener {
    private com.example.jay.myapplication.databinding.FrgmentSevicehallBinding mBinding;
    private AdSeizeAdapter adSeizeAdapter;
    private RecommendSeizeAdapter recommendSeizeAdapter;
    private MainActivity activity;
    private SuccessfulCaseSeizeAdapter successfulCaseSeizeAdapter;
    private boolean xuQiuFang;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.frgment_sevicehall, container, false);
        initView();
        initData();
        return mBinding.getRoot();
    }

    private void initView() {
        activity = (MainActivity) getActivity();
        xuQiuFang = UserInfo.getInstance().isXuQiuFang();
        RecyclerView recyclerView = (RecyclerView) mBinding.getRoot().findViewById(R.id.fragment_service_hall_rl);

        XiaoErBaseSeizeAdapter adapter = new XiaoErBaseSeizeAdapter();
        adSeizeAdapter = new AdSeizeAdapter();
        recommendSeizeAdapter = new RecommendSeizeAdapter();
        successfulCaseSeizeAdapter = new SuccessfulCaseSeizeAdapter();
        adapter.setSeizeAdapters(adSeizeAdapter, recommendSeizeAdapter, successfulCaseSeizeAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        adSeizeAdapter.setOnAdSeizeAdapterListener(this);
        recommendSeizeAdapter.setOnRecommendSeizeAdapterListener(this);
    }

    private void initData() {
        //公告位
        AdBean adBean = new AdBean();
        adBean.setContent("我不是好人，我要做一个坏人，老田你看着办，是死，是活，你一句话，我去解决了小杜");
        Flowable.just(adBean)
                .subscribeOn(Schedulers.io())
                .map(AdVM::new)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adVM -> {
                    adSeizeAdapter.setAdVM(adVM);
                    adSeizeAdapter.setXuQiuFang(xuQiuFang);
                    adSeizeAdapter.notifyDataSetChanged();
                });

        //推荐的数据
        if (xuQiuFang) {
            ArrayList<RecommendBean> recommendList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                RecommendBean recommendBean = new RecommendBean();
                recommendBean.setName("老田");
                recommendBean.setDesc("老田的公司");
                recommendBean.setStar("5.0");
                recommendList.add(recommendBean);
            }

            Flowable.just(recommendList)
                    .subscribeOn(Schedulers.io())
                    .flatMap(Flowable::fromIterable)
                    .map(RecommendVM::new)
                    .toList()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(recommendVMs -> {
                        recommendSeizeAdapter.setHeader(inflaterHeaderOrFooter(R.layout.item_service_recommend_head));
                        recommendSeizeAdapter.setList(recommendVMs);
                        recommendSeizeAdapter.notifyDataSetChanged();
                    });
        }

        //成功安例的数据
        List<SuccessfulCaseBean> caseList = new ArrayList<>();
        if (xuQiuFang) {
            for (int i = 0; i < 10; i++) {
                SuccessfulCaseBean successfulCaseBean = new SuccessfulCaseBean();
                successfulCaseBean.setTv1("老田的公司许可证需求项目");
                successfulCaseBean.setTv2("老杜服务方");
                successfulCaseBean.setTv3("15分钟之前完成");
                caseList.add(successfulCaseBean);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                SuccessfulCaseBean successfulCaseBean = new SuccessfulCaseBean();
                successfulCaseBean.setTv1("老田许可证需求?");
                successfulCaseBean.setTv2("需求内容如下");
                successfulCaseBean.setTv3("15分钟之前发布");
                successfulCaseBean.setTv4("100");
                successfulCaseBean.setTv5("3");
                successfulCaseBean.setTv6("10");
                caseList.add(successfulCaseBean);
            }
        }
        requestSuccessfulCaseData(caseList);
    }

    private void requestSuccessfulCaseData(List<SuccessfulCaseBean> caseList) {
        Flowable.just(caseList)
                .subscribeOn(Schedulers.io())
                .flatMap(Flowable::fromIterable)
                .map(SuccessfulCaseVM::new)
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(successfulCaseVMs -> {
                    if (xuQiuFang) {
                        successfulCaseSeizeAdapter.setHeader(inflaterHeaderOrFooter(R.layout.item_service_successful_case_head));
                    }
                    successfulCaseSeizeAdapter.setXuQiuFang(xuQiuFang);
                    successfulCaseSeizeAdapter.setList(successfulCaseVMs);
                    successfulCaseSeizeAdapter.notifyDataSetChanged();
                });
    }

    private View inflaterHeaderOrFooter(int resId) {
        View view = LayoutInflater.from(getContext()).inflate(resId, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return view;
    }

    @Override
    public void onAdClick() {
        if (activity != null) {
            activity.showToast(getContext(), "我点击了广告栏");
        }
    }

    @Override
    public void onRecommendClick(int position) {
        if (activity != null) {
            activity.showToast(getContext(), "我点击了推荐" + position);
        }
    }
}
