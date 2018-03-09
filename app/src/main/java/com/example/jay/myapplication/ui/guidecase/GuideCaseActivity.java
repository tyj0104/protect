package com.example.jay.myapplication.ui.guidecase;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.base.activity.BaseActivity;
import com.example.jay.myapplication.ui.main.MainActivity;

/**
 * Created by jay on 2017/10/20.
 */

public class GuideCaseActivity extends BaseActivity implements View.OnClickListener {

    private com.example.jay.myapplication.databinding.ActivityGuideBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_guide);
        intView();
    }

    private void intView() {
        mBinding.tv1.setText("排污许可证");
        mBinding.tv1.setBackgroundResource(R.drawable.selector_guide);

        mBinding.tv1.setOnClickListener(this);
        mBinding.tv2.setOnClickListener(this);
        mBinding.tv3.setOnClickListener(this);
        mBinding.tv4.setOnClickListener(this);
        mBinding.tv5.setOnClickListener(this);
        mBinding.tv6.setOnClickListener(this);
        mBinding.tv7.setOnClickListener(this);
        mBinding.tv8.setOnClickListener(this);
        mBinding.tv9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                startActivity(new Intent(GuideCaseActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.tv_2:
                break;
            case R.id.tv_3:
                break;
            case R.id.tv_4:
                break;
            case R.id.tv_5:
                break;
            case R.id.tv_6:
                break;
            case R.id.tv_7:
                break;
            case R.id.tv_8:
                break;
            case R.id.tv_9:
            default:

        }

    }
}
