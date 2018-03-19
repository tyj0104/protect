package com.example.jay.myapplication.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.example.jay.myapplication.R;
import com.example.jay.myapplication.base.activity.BaseActivity;
import com.example.jay.myapplication.bean.AreaBean;
import com.example.jay.myapplication.bean.RegisterModel;
import com.example.jay.myapplication.net.ApiHelper;
import com.example.jay.myapplication.ui.agreement.AgreementActivity;
import com.example.jay.myapplication.utils.JsonFileReader;
import com.example.jay.myapplication.utils.JsonUtil;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/10/17
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener, PopupWindow.OnDismissListener {

    //    private EditText phoneEt;
    private int xq = -1;
    private View popupView;
    private EditText nameEt;
    private String jsonData;
    private TextView areaTv;
    private RadioButton rb_01;
    private RadioButton rb_02;
    private RadioButton rb_08;
    private LinearLayout view;
    private TextView projectTv;
    private EditText passWordEt;
    private EditText passWordOkEt;
    private PopupWindow popupWindow;
    private boolean isFirst = false;
    private RelativeLayout rl_project;
    private OptionsPickerView pvOptions;
    private ArrayList<AreaBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        view = (LinearLayout) findViewById(R.id.register_view_ll);
        nameEt = (EditText) findViewById(R.id.register_et_01);
//        EditText companyEt = (EditText) findViewById(R.id.register_et_02);
//        EditText areaEt = (EditText) findViewById(R.id.register_et_03);
        areaTv = (TextView) findViewById(R.id.register_et_03);
        passWordEt = (EditText) findViewById(R.id.register_et_04);
        passWordOkEt = (EditText) findViewById(R.id.register_et_05);
        projectTv = (TextView) findViewById(R.id.register_et_06);
//        phoneEt = (EditText) findViewById(R.id.register_et_06);

        rb_08 = (RadioButton) findViewById(R.id.register_08_rb);
        rb_01 = (RadioButton) findViewById(R.id.register_01_rb);
        rb_02 = (RadioButton) findViewById(R.id.register_02_rb);
        rl_project = (RelativeLayout) findViewById(R.id.register_project);

        TextView okTv = (TextView) findViewById(R.id.register_ok_tv);
        TextView agreement = (TextView) findViewById(R.id.register_agreement);

        agreement.setOnClickListener(this);
        projectTv.setOnClickListener(this);
        okTv.setOnClickListener(this);
        rb_01.setOnClickListener(this);
        rb_02.setOnClickListener(this);
        rb_08.setOnClickListener(this);
        areaTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_ok_tv://注册按钮
                registerEvent();
                break;
            case R.id.register_agreement://点击协议文字
                startActivity(new Intent(RegisterActivity.this, AgreementActivity.class));
                break;
            case R.id.register_01_rb://需求方
                rb_02.setChecked(false);
                rl_project.setVisibility(View.GONE);
                xq = 1;
                break;
            case R.id.register_02_rb://服务方
                rb_01.setChecked(false);
                rl_project.setVisibility(View.VISIBLE);
                xq = 2;
                break;
            case R.id.register_08_rb://同意协议 按钮
                if (isFirst) {
                    isFirst = false;
                    rb_08.setChecked(false);
                } else {
                    rb_08.setChecked(true);
                    isFirst = true;
                }
                break;
            case R.id.register_et_06:
                //弹出popWindow
                showPopWindow();
                break;
            case R.id.pop_ok_tv:
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                break;
            case R.id.register_et_03:
                initJsonData();
                showAreaPopupWindow();
                break;
            case R.id.pop_02_tv:
                setProjectName("许可证");
                break;
            case R.id.pop_03_tv:
                setProjectName("环评");
                break;
            case R.id.pop_04_tv:
                setProjectName("环境监测");
                break;
            case R.id.pop_05_tv:
                setProjectName("环境管理");
                break;
            default:
                break;
        }
    }

    private void setProjectName(String name) {
        CharSequence text = projectTv.getText();
        String[] split = TextUtils.split((String) text, name);
        if (split.length > 1) {
            showToast(RegisterActivity.this, "已选择");
            return;
        }
        if (TextUtils.isEmpty(text)) {
            projectTv.setText(name);
        } else {
            projectTv.setText(text + "," + name);
        }
    }

    private void showPopWindow() {
        if (popupView == null) {
            popupView = getLayoutInflater().inflate(R.layout.popwindow_register_project, null);
            TextView tv_ok = (TextView) popupView.findViewById(R.id.pop_ok_tv);
            TextView tv_02 = (TextView) popupView.findViewById(R.id.pop_02_tv);
            TextView tv_03 = (TextView) popupView.findViewById(R.id.pop_03_tv);
            TextView tv_04 = (TextView) popupView.findViewById(R.id.pop_04_tv);
            TextView tv_05 = (TextView) popupView.findViewById(R.id.pop_05_tv);
            tv_ok.setOnClickListener(this);
            tv_02.setOnClickListener(this);
            tv_03.setOnClickListener(this);
            tv_04.setOnClickListener(this);
            tv_05.setOnClickListener(this);
        }
        if (popupWindow == null) {
            popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT
                    , ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            popupWindow.setTouchable(true);
            popupWindow.setAnimationStyle(R.style.Register_PopWindow_Animation);
            popupWindow.setOnDismissListener(this);
        }
        backgroundAlpha(this, 0.5f);//0.0-1.0
        popupWindow.showAtLocation(view, Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 0);
    }

    private void registerEvent() {
        String passWord = passWordEt.getText().toString().trim();
        String passWordOk = passWordOkEt.getText().toString().trim();
        if (TextUtils.isEmpty(passWord) || TextUtils.isEmpty(passWordOk)) {
            showToast(RegisterActivity.this, "密码不能为空");
            return;
        }

        if (!passWord.equals(passWordOk)) {
            showToast(RegisterActivity.this, "两次输入的密码不相同,请重新输入");
            return;
        }

        //TODO:手机号正则匹配

//        String phone = phoneEt.getText().toString().trim();
        String name = nameEt.getText().toString().trim();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(passWordOk) && xq != -1 && rb_08.isChecked()) {
            // 弹出Loading  发请注册请求!TextUtils.isEmpty(phone) &&
            if (xq == 2) {
                CharSequence text = projectTv.getText();
                if (TextUtils.isEmpty(text)) {
                    showToast(RegisterActivity.this, "请填写擅长的项目");
                    return;
                }
            }
            showLoadingDialog(RegisterActivity.this, "注册中...");
            register(passWordOk, name);
        } else {
            showToast(RegisterActivity.this, "请完整的填写资料");
        }
    }

    private void register(String passWordOk, String name) {
//        ApiHelper.getApi().regest(ApiHelper.sub_code, ApiHelper.sub_usercode, param_name, phone, passWordOk, name, xq == 1 ? "1" : "0", xq == 1 ? "0" : "1", "1")
        String param_name = "A01_APP_Register";
        ApiHelper.getApi().regest(ApiHelper.sub_code, ApiHelper.sub_usercode, param_name, passWordOk, name, xq == 1 ? "1" : "0", xq == 1 ? "0" : "1", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> {
                    RegisterModel registerModel = JsonUtil.fromJson(o, RegisterModel.class);
                    if (registerModel == null) {
                        showToast(RegisterActivity.this, "网络出现了问题");
                        return;
                    }
                    RegisterModel.A01APPRegisterBean registerBean = registerModel.getA01_APP_Register().get(0);
                    if ("1".equals(registerBean.getS_result())) {
                        cancelLoadingDialog(RegisterActivity.this);
                        finish();
                    } else {
                        showToast(RegisterActivity.this, "注册失败," + registerBean.getError_desc());
                        Log.d("test", "错误原因：" + registerBean.getError_desc());
                    }
                    Log.d("test", "后台返回的字符串：" + o.toString());
                }, e -> Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show());
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }

    @Override
    public void onDismiss() {
        backgroundAlpha(RegisterActivity.this, 1f);
    }

    private void showAreaPopupWindow() {
        //返回的分别是三个级别的选中位置
        if (pvOptions == null) {
            pvOptions = new OptionsPickerView.Builder(this, (options1, options2, options3, v) -> {
                //返回的分别是三个级别的选中位置
                String text = options1Items.get(options1).getPickerViewText() + " " +
                        options2Items.get(options1).get(options2) + " " +
                        options3Items.get(options1).get(options2).get(options3);
                areaTv.setText(text);
            }).setTitleText("")
                    .setDividerColor(Color.GRAY)
                    .setTextColorCenter(Color.GRAY)
                    .setContentTextSize(15)
                    .setOutSideCancelable(false)
                    .build();
          /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
            pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        }
        pvOptions.show();
    }

    private void initJsonData() {   //解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        //  获取json数据
        if (!TextUtils.isEmpty(jsonData)) {
            return;
        }
        jsonData = JsonFileReader.getJson(this, "province_data.json");
        ArrayList<AreaBean> areaList = JsonUtil.jsonParseToList(jsonData, AreaBean.class);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = areaList;
        for (int i = 0; i < areaList.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < areaList.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = areaList.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (areaList.get(i).getCityList().get(c).getArea() == null
                        || areaList.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < areaList.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = areaList.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }
    }
}
