package com.example.jay.myapplication.fragment.tuijian.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.bean.TuiJianBean;
import com.example.jay.myapplication.fragment.tuijian.vm.TuiJianVm;
import com.example.jay.myapplication.widget.RatingBarView;
import com.wangjie.seizerecyclerview.BaseViewHolder;
import com.wangjie.seizerecyclerview.SeizePosition;

/**
 * Created by jay on 2018/3/9.
 */

public class TuiJianViewHolder extends BaseViewHolder implements View.OnClickListener {
    private final  TuijianAdapter mTuijianAdapter;
    private final Context mContext;
    private final TextView tvName;
    private final RatingBarView rbStar;
    private int position;


    public TuiJianViewHolder(TuijianAdapter tuijianAdapter, ViewGroup parent){
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xuqiu_tuijian, parent, false));
        this.mTuijianAdapter = tuijianAdapter;
        mContext = parent.getContext();
        tvName  = (TextView) itemView.findViewById(R.id.item_xuqiu_tuijian_tvName);
        rbStar = (RatingBarView) itemView.findViewById(R.id.item_xiuqiu_tuijian_rb);
        View view = itemView.findViewById(R.id.item_tuijian_prarent);
        view.setOnClickListener(this);
    }


    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, SeizePosition seizePosition) {
        position = seizePosition.getSubSourcePosition();
        TuiJianVm tuiJianVm = mTuijianAdapter.getList().get(position);
        if (null == tuiJianVm) {
            return;
        }
        TuiJianBean tuiJianBean = tuiJianVm.getModel();

        tvName.setText(tuiJianBean.getName());
        String star = tuiJianBean.getStar();
        if (TextUtils.isDigitsOnly(star)) {
            rbStar.setRating(Float.valueOf(star));
        }

    }

    @Override
    public void onClick(View view) {
        TuijianAdapter.TuiJianAdapterListener tuiJianAdapterListener = mTuijianAdapter.getTuiJianAdapterListener();
        switch (view.getId()) {
            case R.id.item_tuijian_prarent:
                if (tuiJianAdapterListener != null) {
                    tuiJianAdapterListener.onTuijianClick(position);
                }
                break;
            default:
        }

    }
}
