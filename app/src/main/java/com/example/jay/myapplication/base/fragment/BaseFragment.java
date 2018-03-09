package com.example.jay.myapplication.base.fragment;

import android.app.Activity;
import android.content.Intent;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by jay on 2017/10/19.
 */

public class BaseFragment extends RxFragment {
    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(getActivity(), activity));
    }

    public void startActivity(Class<? extends Activity> activity, boolean needFinished) {
        startActivity(new Intent(getActivity(), activity));
        if (needFinished) {
            getActivity().finish();
        }
    }

    public void startActivityForResult(Class<? extends Activity> activity, int requestCode) {
        startActivityForResult(new Intent(getActivity(), activity), requestCode);
    }

    public void startActivityForResult(Class<? extends Activity> activity, int requestCode, boolean needFinished) {
        startActivityForResult(new Intent(getActivity(), activity), requestCode);
        if (needFinished) {
            getActivity().finish();
        }
    }

    public void startActivityForResult(Intent intent, int requestCode, boolean needFinished) {
        startActivityForResult(intent, requestCode);
        if (needFinished) {
            getActivity().finish();
        }
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }
}
