package com.example.jay.myapplication.fragment.tuijian.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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


    private final ImageView pic;
    private final TextView desc;
    private final TextView tvName;
    private final TextView scroeNum;
    private final TextView company_name;
    private final RatingBarView rbStar;
    private int position;

    public TuiJianViewHolder(TuijianAdapter tuijianAdapter, ViewGroup parent){
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service_recommend, parent, false));
        this.mTuijianAdapter = tuijianAdapter;
        mContext = parent.getContext();
        pic = (ImageView) itemView.findViewById(R.id.item_service_recommend_iv);//负责人头像
        tvName = (TextView) itemView.findViewById(R.id.item_service_recommend_name_tv);//负责人
        desc = (TextView) itemView.findViewById(R.id.item_service_recommend_desc_tv);//成功安例有几个
        scroeNum = (TextView) itemView.findViewById(R.id.item_service_recommend_score_num);//评分
        company_name = (TextView) itemView.findViewById(R.id.item_service_recommend_company_name_tv);//公司名称
        rbStar = (RatingBarView) itemView.findViewById(R.id.item_service_recommend_rb);
        RelativeLayout view = (RelativeLayout) itemView.findViewById(R.id.item_service_recommend_view);
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
        scroeNum.setText(tuiJianBean.getCodeNum());
        String star = tuiJianBean.getStar();
        if (TextUtils.isDigitsOnly(star)) {
            rbStar.setRating(Float.valueOf(star));
        }

    }

    @Override
    public void onClick(View view) {
        TuijianAdapter.TuiJianAdapterListener tuiJianAdapterListener = mTuijianAdapter.getTuiJianAdapterListener();
        switch (view.getId()) {
            case R.id.item_service_recommend_view:
                if (tuiJianAdapterListener != null) {
                    tuiJianAdapterListener.onTuijianClick(position);
                }
                break;
            default:
        }

    }
}
