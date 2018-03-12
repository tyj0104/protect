package com.example.jay.myapplication.fragment.service.adapter.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jay.myapplication.R;
import com.example.jay.myapplication.bean.RecommendBean;
import com.example.jay.myapplication.fragment.service.vm.RecommendVM;
import com.example.jay.myapplication.utils.gilde.CircleTransform;
import com.example.jay.myapplication.widget.RatingBarView;
import com.wangjie.seizerecyclerview.BaseViewHolder;
import com.wangjie.seizerecyclerview.SeizePosition;

/**
 * Created by Administrator on 2017/10/20
 */

public class RecommendSeizeAdapterViewHolder extends BaseViewHolder implements View.OnClickListener {
    private final RecommendSeizeAdapter recommendSeizeAdapter;
    private final ImageView pic;
    private final TextView desc;
    private final RatingBarView star;
    private final TextView name;
    private final Context context;
    private final TextView scroeNum;
    private final TextView company_name;
    private int position;

    public RecommendSeizeAdapterViewHolder(RecommendSeizeAdapter recommendSeizeAdapter, ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service_recommend, parent, false));
        this.recommendSeizeAdapter = recommendSeizeAdapter;
        context = parent.getContext();
        pic = (ImageView) itemView.findViewById(R.id.item_service_recommend_iv);//负责人头像
        name = (TextView) itemView.findViewById(R.id.item_service_recommend_name_tv);//负责人
        desc = (TextView) itemView.findViewById(R.id.item_service_recommend_desc_tv);//成功安例有几个
        scroeNum = (TextView) itemView.findViewById(R.id.item_service_recommend_score_num);//评分
        company_name = (TextView) itemView.findViewById(R.id.item_service_recommend_company_name_tv);//公司名称
        star = (RatingBarView) itemView.findViewById(R.id.item_service_recommend_rb);
        RelativeLayout view = (RelativeLayout) itemView.findViewById(R.id.item_service_recommend_view);

        view.setOnClickListener(this);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, SeizePosition seizePosition) {
        position = seizePosition.getSubSourcePosition();
        RecommendVM recommendVM = recommendSeizeAdapter.getList().get(position);
        if (recommendVM == null) {
            return;
        }
        RecommendBean model = recommendVM.getModel();
        name.setText(model.getName());
        desc.setText("成功案例：6 | 擅长：许可证、环评、环境咨询");
        star.setStar(Float.valueOf(model.getStar()));

        Glide.with(context)
                .load(model.getPic())
                .transform(new CircleTransform(context))
                .into(pic);
    }

    @Override
    public void onClick(View v) {
        RecommendSeizeAdapter.OnRecommendSeizeAdapterListener onRecommendSeizeAdapterListener = recommendSeizeAdapter.getOnRecommendSeizeAdapterListener();
        switch (v.getId()) {
            case R.id.item_service_recommend_view:
                if (onRecommendSeizeAdapterListener != null) {
                    onRecommendSeizeAdapterListener.onRecommendClick(position);
                }
                break;
            default:
                break;
        }
    }
}
