package com.example.jay.myapplication.base.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/10/19
 */

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog loadingDialog;
    private Toast toast;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //点空白处不会消失的
    public void showLoadingDialog(Context context, String message) {
        if (!checkViewer(context)) {
            return;
        }

        if (null == loadingDialog) {
            loadingDialog = new ProgressDialog(context);
            loadingDialog.setCanceledOnTouchOutside(false);
        }
        loadingDialog.setMessage(message);
        loadingDialog.show();
    }

    public void cancelLoadingDialog(Context context) {
        if (!checkViewer(context)) {
            return;
        }
        if (null != loadingDialog) {
            loadingDialog.cancel();
        }
    }

    public void showToast(Context context, String message) {
        if (!checkViewer(context)) {
            return;
        }
        if (null == toast) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        toast.setText(message);
        toast.show();
    }

    /**
     * 检测context是否为null
     * 因为在Viewer销毁时会调用onViewerDestroy,会置空context,所以如果context不是null,则说明Viewer还存在
     *
     * @param context
     */
    private boolean checkViewer(Context context) {
        if (null == context) {
            return false;
        }
        return !(context instanceof Activity && isActivityFinishingOrDestroy((Activity) context));
    }

    private boolean isActivityFinishingOrDestroy(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            return activity.isFinishing() || activity.isDestroyed();
        } else {
            return activity.isFinishing();
        }
    }
}
