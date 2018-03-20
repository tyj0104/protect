package com.example.jay.myapplication.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.jay.myapplication.R;

/**
 * author:hll
 * time:2018/3/20
 */

public class BackToolbar extends RelativeLayout implements View.OnClickListener {
    private OnBackListener onBackListener;

    public BackToolbar(Context context) {
        super(context);
        init();
    }

    public BackToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BackToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = View.inflate(getContext(), R.layout.back_toolbar, this);
        RelativeLayout back = (RelativeLayout) view.findViewById(R.id.back_toolbar_view);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_toolbar_view:
                if (onBackListener != null) {
                    onBackListener.onBackClick();
                }
                break;
            default:
                break;
        }
    }

    public interface OnBackListener {
        void onBackClick();
    }

    public void setOnBackListener(OnBackListener onBackListener) {
        this.onBackListener = onBackListener;
    }
}
