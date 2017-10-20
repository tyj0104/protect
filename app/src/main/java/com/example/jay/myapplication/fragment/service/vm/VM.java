package com.example.jay.myapplication.fragment.service.vm;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * 基本的VM
 *
 * Created by Administrator on 16/1/8.
 */
public class VM<T> implements Serializable {

    private T model;

    public VM(@NonNull T model) {
        this.model = model;
    }

    @NonNull
    public T getModel() {
        return model;
    }

    public void setModel(@NonNull T model) {
        this.model = model;
    }

    public int getViewType(){
        return 0;
    }
}
