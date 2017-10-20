package com.example.jay.myapplication.ui.main;


import com.example.jay.myapplication.fragment.BaseFragment;
import com.example.jay.myapplication.fragment.CaseFragment;
import com.example.jay.myapplication.fragment.MyMsgFragment;
import com.example.jay.myapplication.fragment.service.ServiceFragment;
import com.example.jay.myapplication.fragment.TuijianFragment;
import com.example.jay.myapplication.fragment.UserIfnoFragment;

public class FragmentFactory {
    private static ServiceFragment sServiceFragment;
    private static TuijianFragment sTuijianFragment;
    private static MyMsgFragment sMyMsgFragment;
    private static CaseFragment sCaseFragment;
    private static UserIfnoFragment sUserIfnoFragment;



    public static BaseFragment getFragment(int id) {
        BaseFragment baseFragment = null;
        switch (id) {
            case 0:
                if (sServiceFragment == null) {
                    sServiceFragment = new ServiceFragment();
                }
                baseFragment = sServiceFragment;
                break;
            case 1:
                if (sTuijianFragment == null) {
                    sTuijianFragment = new TuijianFragment();
                }
                baseFragment = sTuijianFragment;
                break;
            case 2:
                if (sMyMsgFragment == null) {
                    sMyMsgFragment = new MyMsgFragment();
                }
                baseFragment = sMyMsgFragment;
                break;
            case 3:
                if (sCaseFragment == null) {
                    sCaseFragment = new CaseFragment();
                }
                baseFragment = sCaseFragment;
                break;
            case 4:
                if (sUserIfnoFragment == null) {
                    sUserIfnoFragment = new UserIfnoFragment();
                }
                baseFragment = sUserIfnoFragment;
                break;
        }
        return baseFragment;
    }




}
