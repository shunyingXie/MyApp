package com.example.gaoqing.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText password_word;
    private EditText password_ensure;
    private Button register;
    private Button backlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);


        register = (Button)findViewById(R.id.password_register);
        backlogin = (Button)findViewById(R.id.password_backlogin);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.password_register:
                password_word = (EditText)findViewById(R.id.password_word);
                password_ensure = (EditText)findViewById(R.id.password_sure);
                //发送到服务器



                //返回响应报文



                //注册成功，跳转到登录页面
                startActivity(new Intent(PasswordActivity.this, LoginActivity.class));

                break;

            case R.id.password_backlogin:
                startActivity(new Intent(PasswordActivity.this, LoginActivity.class));
                break;
        }
    }
}
