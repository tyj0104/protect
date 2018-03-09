package com.example.jay.myapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.utils.ResUtil;


public class RatingBarView extends LinearLayout {


    //    private boolean mClickable = true;
    private float starSize;
    private int starCount;
    private Drawable starEmptyDrawable;
    private Drawable starFillDrawable;
    private Drawable starHalfDrawable;

    public float defaultStarSize = 20;//默认星星大小
    public int defaultStarCount = 5;//默认星星个数

//    public void setClickable(boolean clickable) {
//        this.mClickable = clickable;
//    }

    public RatingBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RatingBarView);
        starSize = ta.getDimension(R.styleable.RatingBarView_starSize, defaultStarSize);
        starCount = ta.getInteger(R.styleable.RatingBarView_starCount, defaultStarCount);
        starEmptyDrawable = ta.getDrawable(R.styleable.RatingBarView_starEmpty);
        starFillDrawable = ta.getDrawable(R.styleable.RatingBarView_starFill);
        starHalfDrawable = ta.getDrawable(R.styleable.RatingBarView_starHalf);
        ta.recycle();

        for (int i = 0; i < starCount; ++i) {
            ImageView imageView = getStarImageView(context, attrs);
            addView(imageView);
        }
    }

    private ImageView getStarImageView(Context context, AttributeSet attrs) {
        ImageView imageView = new ImageView(context);
        ViewGroup.LayoutParams para = new ViewGroup.LayoutParams(Math.round(starSize), Math.round(starSize));
        imageView.setLayoutParams(para);
        // TODO:you can change gap between two stars use the padding
        imageView.setPadding(0, 0, ResUtil.dip2px(7), 0);
        imageView.setImageDrawable(starEmptyDrawable);
        imageView.setMaxWidth(10);
        imageView.setMaxHeight(10);
        return imageView;
    }

    public void setStar(float starNum) {
        boolean isHalfStar = (starNum + 0.5f) >= ((int) starNum + 1);//判断传进来的星星个数是不是要有半个
        int count = isHalfStar ? (int) starNum + 1 : (int) starNum;
        if (count > 5) {//最多5个星星
            count = 5;
        }
        for (int i = 0; i < count; ++i) {
            if (i == count - 1 && isHalfStar && starNum != 5.0) {
                ((ImageView) getChildAt(i)).setImageDrawable(starHalfDrawable);
                break;
            }
            ((ImageView) getChildAt(i)).setImageDrawable(starFillDrawable);
        }
        for (int i = this.starCount - 1; i >= count; --i) {
            ((ImageView) getChildAt(i)).setImageDrawable(starEmptyDrawable);
        }
    }

    public void setRating(float starNum) {
        setStar(starNum);
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarFillDrawable(Drawable starFillDrawable) {
        this.starFillDrawable = starFillDrawable;
    }

    public void setStarEmptyDrawable(Drawable starEmptyDrawable) {
        this.starEmptyDrawable = starEmptyDrawable;
    }

    public void setStarHalfDrawable(Drawable starHalfDrawable) {
        this.starHalfDrawable = starHalfDrawable;
    }

    public void setStarCount(int startCount) {
        this.starCount = startCount;
    }

    public void setStarSize(float starSize) {
        this.starSize = starSize;
    }

}
