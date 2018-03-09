package com.example.jay.myapplication.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.jay.myapplication.R;
import com.example.jay.myapplication.bean.UserInfo;
import com.example.jay.myapplication.databinding.ActivityMainBinding;
import com.example.jay.myapplication.fragment.BaseFragment;
import com.example.jay.myapplication.net.ApiHelper;
import com.example.jay.myapplication.ui.BaseActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.HEAD;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private ActivityMainBinding binding;
    private BottomNavigationBar mNavigationBar;
    private String[] titleIds = {"服务大厅", "服务推荐", "我的消息", "成功案例", "个人中心"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initBottomNavigationBar();
        printLog();
        setDefaultFragment();

  //     test();
    }

    private void initBottomNavigationBar() {
        boolean xuQiuFang = UserInfo.getInstance().isXuQiuFang();
        mNavigationBar = binding.bottomNavigationBar;

        BottomNavigationItem serviceHallItem = new BottomNavigationItem(R.mipmap.hall, xuQiuFang ? "服务大厅" : "需求大厅");
        mNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        serviceHallItem.setInactiveIconResource(R.mipmap.hall);
        mNavigationBar.addItem(serviceHallItem);

        BottomNavigationItem recommendItem = new BottomNavigationItem(R.mipmap.tuijian, xuQiuFang ? "服务推荐" : "我的关注");
        recommendItem.setInactiveIconResource(R.mipmap.tuijian);
        mNavigationBar.addItem(recommendItem);

        BottomNavigationItem myMsgItem = new BottomNavigationItem(R.mipmap.msg, "我的消息");
        mNavigationBar.addItem(myMsgItem);
        myMsgItem.setInactiveIconResource(R.mipmap.msg);


        BottomNavigationItem successfulCaseItem = new BottomNavigationItem(R.mipmap.seccase, xuQiuFang ? "成功案例" : "我的历史");
        mNavigationBar.addItem(successfulCaseItem);
        successfulCaseItem.setInactiveIconResource(R.mipmap.seccase);


        BottomNavigationItem perInformation = new BottomNavigationItem(R.mipmap.user, "个人中心");
        mNavigationBar.addItem(perInformation);
        perInformation.setInactiveIconResource(R.mipmap.user);

        mNavigationBar.setActiveColor(R.color.colorbottom);

        mNavigationBar.initialise();
        mNavigationBar.setTabSelectedListener(this);


    }

    private void setDefaultFragment() {

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        for (int i = 0; i < titleIds.length; i++) {
            Fragment fragment = supportFragmentManager.findFragmentByTag("" + i);
            if (fragment != null) {
                fragmentTransaction.remove(fragment);
            }
        }
        fragmentTransaction.add(R.id.fragmet_content, FragmentFactory.getFragment(0), "0");
        fragmentTransaction.commit();


    }

    private void test() {
        ApiHelper.getApi().SelServList1(UserInfo.getInstance().sub_code, UserInfo.getInstance().getSub_usercode(),
                "A01_APP_SelServList1", UserInfo.getInstance().getSession_id(), UserInfo.getInstance().getLogin_id(),
                UserInfo.getInstance().getLogin_id(), "0", "10")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> {
                    System.out.println(" =======A01_APP_SelServList1 == " + o.toString());
                }, e -> Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show());
    }

    private void printLog() {
        Log.e("MainActivity", "Login_id ==== " + UserInfo.getInstance().getLogin_id());
        Log.e("MainActivity", "Session_id ==== " + UserInfo.getInstance().getSession_id());
        Log.e("MainActivity", "Nickname ==== " + UserInfo.getInstance().getNickname());
        Log.e("MainActivity", "ALI_ACCOUNT ==== " + UserInfo.getInstance().getALI_ACCOUNT());
        Log.e("MainActivity", "M_ACCOUNT ==== " + UserInfo.getInstance().getM_ACCOUNT());
        Log.e("MainActivity", "getSub_code ==== " + UserInfo.getInstance().getSub_code());
        Log.e("MainActivity", "Sub_usercode ==== " + UserInfo.getInstance().getSub_usercode());
    }

    @Override
    public void onTabSelected(int position) {
        /**
         * 先判断当前Fragment是否被添加到了zhuActivity中
         * 如果添加了则直接显示即可
         * 如果没有添加则添加，然后显示
         */
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        BaseFragment fragment = FragmentFactory.getFragment(position);
        if (!fragment.isAdded()) {
            transaction.add(R.id.fragmet_content, fragment, "" + position);
        }
        transaction.show(fragment).commit();


    }

    @Override
    public void onTabUnselected(int position) {
        getSupportFragmentManager().beginTransaction().hide(FragmentFactory.getFragment(position)).commit();
    }

    @Override
    public void onTabReselected(int position) {

    }
}
