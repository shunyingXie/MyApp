package com.example.gaoqing.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import checkUtils.TelCheck;
import timecountUtils.TimeCount;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class PhoneActivity extends AppCompatActivity implements View.OnClickListener{


    private EditText userName;
    private EditText validateCode;
    private Button validateCode_btn;
    private Button login_btn;


    public EventHandler eh; //事件接收器
    private TimeCount mTimeCount;//计时器

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        initEvent();
        init();
    }

    private void initEvent(){
        userName = (EditText) findViewById(R.id.username);
        validateCode = (EditText) findViewById(R.id.validate_code);
        validateCode_btn = (Button) findViewById(R.id.validate_code_btn);
        login_btn = (Button) findViewById(R.id.login_btn);
        validateCode_btn.setOnClickListener(this);
        login_btn.setOnClickListener(this);
        mTimeCount = new TimeCount(validateCode_btn,60000, 1000);
    }

    /**
     * 初始化事件接收器
     */
    private void init(){
        eh = new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {

                if (result == SMSSDK.RESULT_COMPLETE) { //回调完成


                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) { //提交验证码成功

                        startActivity(new Intent(PhoneActivity.this, HomepageActivity.class)); //页面跳转

                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){ //获取验证码成功


                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){ //返回支持发送验证码的国家列表

                    }
                }else{
                    ((Throwable)data).printStackTrace();
                }
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.validate_code_btn:
//                SMSSDK.getSupportedCountries();//获取短信目前支持的国家列表
                if(!userName.getText().toString().trim().equals("")){
                    if (TelCheck.checkTel(userName.getText().toString().trim())) {
                        SMSSDK.getVerificationCode("+86",userName.getText().toString());//获取验证码
                        mTimeCount.start();
                    }else{
                        Toast.makeText(PhoneActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(PhoneActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.login_btn:
                if (!userName.getText().toString().trim().equals("")) {
                    if (TelCheck.checkTel(userName.getText().toString().trim())) {
                        if (!validateCode.getText().toString().trim().equals("")) {
                            SMSSDK.submitVerificationCode("+86",userName.getText().toString().trim(),validateCode.getText().toString().trim());//提交验证
                        }else{
                            Toast.makeText(PhoneActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(PhoneActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(PhoneActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eh);
    }


}
