package com.example.jay.myapplication.ui.successfulcasedetail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jay.myapplication.R;
import com.example.jay.myapplication.base.activity.BaseActivity;
import com.example.jay.myapplication.databinding.ActivitySuccessfulcasedetailBinding;
import com.example.jay.myapplication.utils.ResUtil;
import com.example.jay.myapplication.widget.RatingBarView;

/**
 * author:hll
 * time:2018/3/19
 */

public class SuccessfulCaseDetailActivity extends BaseActivity implements View.OnClickListener {

    private ActivitySuccessfulcasedetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_successfulcasedetail);
        initView();
    }

    private void initView() {
        RelativeLayout backRl = (RelativeLayout) binding.getRoot().findViewById(R.id.activity_successful_case_detail_back);
        TextView projectNameTv = (TextView) binding.getRoot().findViewById(R.id.activity_successful_case_detail_project);
        TextView priceTv = (TextView) binding.getRoot().findViewById(R.id.activity_successful_case_detail_price);
        TextView timeTv = (TextView) binding.getRoot().findViewById(R.id.activity_successful_case_detail_time);
        TextView companyTv = (TextView) binding.getRoot().findViewById(R.id.activity_successful_case_detail_company);
        TextView contentTv = (TextView) binding.getRoot().findViewById(R.id.activity_successful_case_detail_content);
        TextView infoNameTv = (TextView) binding.getRoot().findViewById(R.id.item_service_recommend_name_tv);
        TextView infoDescTv = (TextView) binding.getRoot().findViewById(R.id.item_service_recommend_desc_tv);
        TextView infoCompanyTv = (TextView) binding.getRoot().findViewById(R.id.item_service_recommend_company_name_tv);
        TextView infoScoreTv = (TextView) binding.getRoot().findViewById(R.id.item_service_recommend_score_num);
        RatingBarView infoStartRb = (RatingBarView) binding.getRoot().findViewById(R.id.item_service_recommend_rb);
        View line = binding.getRoot().findViewById(R.id.item_service_recommend_line);
        ImageView infoPicIv = (ImageView) binding.getRoot().findViewById(R.id.item_service_recommend_iv);
        RelativeLayout serverInfo = (RelativeLayout) binding.getRoot().findViewById(R.id.activity_successful_case_detail_include);
        line.setVisibility(View.GONE);
        backRl.setOnClickListener(this);
        serverInfo.setOnClickListener(this);
        //设置数据
        projectNameTv.setText("项目  某某某某许可证项目需求");
        priceTv.setText("悬赏钻石：500");
        timeTv.setText("发起时间：2017-02-24 |");
        companyTv.setText("发起公司：杭州污水处理厂");
        String s = "内容:";
        SpannableString span = new SpannableString(s);
        span.setSpan(new ForegroundColorSpan(ResUtil.getColor(R.color.project_main_tv)), 0, s.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        contentTv.setText(span + "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容");
        infoNameTv.setText("陈建忠");
        infoDescTv.setText("成功安例:6 | 擅长：许可证、环境、环境咨询");
        infoCompanyTv.setText("浙江省环境股份有限公司");
        infoScoreTv.setText("5分");
        infoStartRb.setStar(5);
        Glide.with(this)
                .load("")
                .placeholder(R.mipmap.icon_)
                .error(R.mipmap.icon_)
                .into(infoPicIv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_successful_case_detail_back:
                finish();
                break;
            case R.id.activity_successful_case_detail_include:
                showToast(this, "我要跳转");
                break;
            default:
                break;
        }
    }
}
