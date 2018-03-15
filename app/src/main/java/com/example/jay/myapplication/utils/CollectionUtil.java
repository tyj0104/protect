package com.example.jay.myapplication.utils;

import android.support.annotation.Nullable;

import java.util.Collection;

/**
 * Author: wangjie Email: tiantian.china.2@gmail.com Date: 11/8/16.
 */
public class CollectionUtil {
    public static boolean isEmpty(@Nullable Collection collection) {
        return null == collection || 0 == collection.size();
    }
}
