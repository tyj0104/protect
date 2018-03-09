package com.example.jay.myapplication.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import com.example.jay.myapplication.XiaoerApplication;

/**
 * Author: wangjie Email: tiantian.china.2@gmail.com Date: 11/5/16.
 */
public class ResUtil {
//    public static Drawable DEFAULT_PLACE_HOLDER = new ColorDrawable(Color.GRAY);

    public static int dip2px(float dpValue) {
        try {
            final float scale = XiaoerApplication.getInstances().getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        } catch (Throwable throwable) {
            // igonre
        }
        return 0;
    }

    public static int sp2px(float spValue) {
        try {
            float fontScale = XiaoerApplication.getInstances().getResources().getDisplayMetrics().scaledDensity;
            return (int) (spValue * fontScale + 0.5f);
        } catch (Throwable throwable) {
            // ignore
        }
        return 0;
    }

    public static int px2dip(float pxValue) {
        try {
            float scale = XiaoerApplication.getInstances().getResources().getDisplayMetrics().density;
            return (int) (pxValue / scale + 0.5f);
        } catch (Throwable throwable) {
            // ignore
        }
        return 0;
    }

    public static String getString(int resId) {
        try {
            return XiaoerApplication.getInstances().getString(resId);
        } catch (Throwable throwable) {
            // ignore
        }
        return "";
    }

    public static String getString(int resId, Object... formatArgs) {
        try {
            return XiaoerApplication.getInstances().getString(resId, formatArgs);
        } catch (Throwable throwable) {
            // ignore
        }
        return "";
    }

    public static String[] getArrayString(int resId) {
        try {
            return XiaoerApplication.getInstances().getResources().getStringArray(resId);
        } catch (Throwable throwable) {
            // ignore
        }
        return new String[0];
    }

    public static int getColor(int resId) {
        try {
            return XiaoerApplication.getInstances().getResources().getColor(resId);
        } catch (Throwable throwable) {
            // ignore
        }
        return 0;
    }

    public static float getDimension(int resId) {
        try {
            return XiaoerApplication.getInstances().getResources().getDimension(resId);
        } catch (Throwable throwable) {
            // ignore
        }
        return 0;
    }

    public static float getDimensionPixelSize(int resId) {
        try {
            return XiaoerApplication.getInstances().getResources().getDimensionPixelSize(resId);
        } catch (Throwable throwable) {
            // ignore
        }
        return 0;
    }

    public static Drawable getDrawable(int resId) {
        try {
            return ContextCompat.getDrawable(XiaoerApplication.getInstances(), resId);
        } catch (Throwable throwable) {
            // ignore
        }
        return new ColorDrawable(Color.TRANSPARENT);
    }

    /**
     * 获取屏幕宽度
     */
    public static int getWindowWidth() {
        DisplayMetrics dm = XiaoerApplication.getInstances().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getWindowHeight() {
        DisplayMetrics dm = XiaoerApplication.getInstances().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public static void scrollToPosition(RecyclerView recyclerView, int position) {
        recyclerView.stopScroll();
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();
        if (position <= firstVisiblePosition) {// 置顶位置在屏幕上面
            recyclerView.smoothScrollToPosition(position);
        } else if (position <= lastVisiblePosition) {// 置顶位置在屏幕上
            int top = recyclerView.getChildAt(position - firstVisiblePosition).getTop();
            recyclerView.smoothScrollBy(0, top);
        } else {// 置顶位置在屏幕下面
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        int n = position - ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                        if (0 <= n && n < recyclerView.getChildCount()) {
                            int top = recyclerView.getChildAt(n).getTop();
                            recyclerView.smoothScrollBy(0, top);
                        }
                        recyclerView.removeOnScrollListener(this);
                    }
                }
            });
            recyclerView.smoothScrollToPosition(position);
        }
    }

//    private static int getHeightByWidth(int height, int width) {
//        int newHeight = height;
//        try {
//            newHeight = getWindowWidth(true) * height / width;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return newHeight;
//    }
//
//    /**
//     * 获取屏幕的亮度
//     *
//     * @param activity
//     * @return
//     */
//    public static int getScreenBrightness(Activity activity) {
//        int nowBrightnessValue = 0;
//        ContentResolver resolver = activity.getContentResolver();
//        try {
//            nowBrightnessValue = android.provider.Settings.System.getInt(
//                    resolver, Settings.System.SCREEN_BRIGHTNESS);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return nowBrightnessValue;
//    }
//
//    /**
//     * @param context
//     * @param brightness
//     */
//    public static void setScreenBrightness(Activity context, float brightness) {
////        brightness = brightness <= 10 ? 10 : brightness;
////        brightness = brightness >= 255 ? 255 : brightness;
//        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
//        lp.screenBrightness = brightness / 255f;
//        context.getWindow().setAttributes(lp);
//    }

    public static void recycleBitmap(Bitmap... bitmaps) {
        for (Bitmap bitmap : bitmaps) {
            if (null != bitmap && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

}
