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
import com.example.jay.myapplication.databinding.FrgmentTuijianBinding;
import com.example.jay.myapplication.fragment.BaseFragment;
import com.example.jay.myapplication.fragment.service.vm.RecommendVM;
import com.example.jay.myapplication.fragment.tuijian.adapter.TuiJianBean;
import com.example.jay.myapplication.fragment.tuijian.adapter.TuijianAdapter;
import com.example.jay.myapplication.fragment.tuijian.vm.TuiJianVm;
import com.example.jay.myapplication.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jay on 2017/10/19.
 */

public class TuijianFragment extends BaseFragment {
    private FrgmentTuijianBinding mBinding;

    private MainActivity activity;

    private boolean xuQiuFang;

   private RecyclerView recll;
    private TuiJianPrarentAdapter mTuiJianPrarentAdapter;
    private TuijianAdapter mTuijianAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.frgment_tuijian, container, false);
        initView();
        initDatas();
        return mBinding.getRoot();
    }
    private void initView() {
        activity = (MainActivity) getActivity();
        xuQiuFang = UserInfo.getInstance().isXuQiuFang();
        recll = (RecyclerView) mBinding.getRoot().findViewById(R.id.fragment_tuijian_hall_rl);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recll.setLayoutManager(linearLayoutManager);
        TuiJianPrarentAdapter prarentAdapter = new TuiJianPrarentAdapter();
        mTuijianAdapter = new TuijianAdapter();
        prarentAdapter.setSeizeAdapters(mTuijianAdapter);
        recll.setAdapter(prarentAdapter);
    }

    private void initDatas() {
        List<TuiJianBean> list;
        if (!xuQiuFang) {
         list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            TuiJianBean ben = new TuiJianBean();
            ben.setName("泰勒");
            if (i < 5) {
                ben.setStar(i + "");
            } else {
                ben.setStar("5");
            }
            list.add(ben);
        }
            Flowable.just(list)
                    .subscribeOn(Schedulers.io())
                    .flatMap(Flowable::fromIterable)
                    .map(TuiJianVm::new)
                    .toList()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(tuijianVms -> {
                        mTuijianAdapter.setList(tuijianVms);
                        mTuijianAdapter.notifyDataSetChanged();
                    });
        }




    }

}
