package com.example.jay.myapplication.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jay.myapplication.R;
import com.example.jay.myapplication.ui.agreement.AgreementActivity;

/**
 * Created by Administrator on 2017/10/17
 */

public class RegisterActivity extends Activity implements View.OnClickListener {

    private EditText phoneEt;
    private EditText nameEt;
    private EditText passWordEt;
    private EditText passWordOkEt;
    private RadioButton rb_01;
    private RadioButton rb_02;
    private RadioButton rb_08;
    private int xq = -1;
    private boolean isFirst = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        nameEt = (EditText) findViewById(R.id.register_et_01);
//        EditText companyEt = (EditText) findViewById(R.id.register_et_02);
//        EditText areaEt = (EditText) findViewById(R.id.register_et_03);
        passWordEt = (EditText) findViewById(R.id.register_et_04);
        passWordOkEt = (EditText) findViewById(R.id.register_et_05);
        phoneEt = (EditText) findViewById(R.id.register_et_06);

        rb_08 = (RadioButton) findViewById(R.id.register_08_rb);
        rb_01 = (RadioButton) findViewById(R.id.register_01_rb);
        rb_02 = (RadioButton) findViewById(R.id.register_02_rb);

        TextView okTv = (TextView) findViewById(R.id.register_ok_tv);
        TextView agreement = (TextView) findViewById(R.id.register_agreement);

        agreement.setOnClickListener(this);
        okTv.setOnClickListener(this);
        rb_01.setOnClickListener(this);
        rb_02.setOnClickListener(this);
        rb_08.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_ok_tv://注册按钮
                String passWord = passWordEt.getText().toString().trim();
                String passWordOk = passWordOkEt.getText().toString().trim();
                if (TextUtils.isEmpty(passWord) || TextUtils.isEmpty(passWordOk)) {
                    Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!passWord.equals(passWordOk)) {
                    Toast.makeText(RegisterActivity.this, "两次输入的密码不相同,请重新输入", Toast.LENGTH_SHORT).show();
                    return;
                }

                String phone = phoneEt.getText().toString().trim();
                String name = nameEt.getText().toString().trim();
                if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(passWordOk) && xq != -1 && rb_08.isChecked()) {
                    // 弹出Loading  发请注册请求
                    Toast.makeText(RegisterActivity.this, "我要注册", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "请完整的填写资料", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.register_agreement://点击协议文字
                startActivity(new Intent(RegisterActivity.this, AgreementActivity.class));
                break;
            case R.id.register_01_rb://需求方
                rb_02.setChecked(false);
                xq = 1;
                break;
            case R.id.register_02_rb://服务方
                rb_01.setChecked(false);
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
        }
    }
}
