package com.example.jay.myapplication.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jay on 2018/3/9.
 */
@Getter
@Setter
public class TuiJianBean implements Serializable {
    private String name;
    private String star;
    private String codeNum;
}
