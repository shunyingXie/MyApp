package com.example.gaoqing.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import checkUtils.TelCheck;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		//注册按钮跳转
		Button signup_btn=(Button)findViewById(R.id.login_signup_btn);
		signup_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});

		//手机验证码登录页面
		Button validatelogin_btn=(Button)findViewById(R.id.login_validatelogin_btn);
		validatelogin_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(LoginActivity.this, PhoneActivity.class);
				startActivity(intent);
			}
		});

		//忘记密码页面
		Button forgetpassword_btn=(Button)findViewById(R.id.login_forgetpassword_btn);
		forgetpassword_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);
				startActivity(intent);
			}
		});

		//登录按钮，验证成功跳转到主页
		Button login_btn=(Button)findViewById(R.id.login_login_btn);
		login_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {



				String username = ((EditText)findViewById(R.id.login_username)).getText().toString().trim();
				String password = ((EditText)findViewById(R.id.login_password)).getText().toString().trim();

				Toast.makeText(LoginActivity.this, username, Toast.LENGTH_SHORT).show();

				if(TelCheck.checkTel(username)){
					//发送登录报文到服务器


					//接收到返回的报文
					int res_code = 0;
					//登录成功
					if(res_code==1){
						Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
						startActivity(intent);
					}else{
						String res_describe = "";
						Toast.makeText(LoginActivity.this, res_describe, Toast.LENGTH_SHORT).show();
					}
				}else{
					Toast.makeText(LoginActivity.this,"请输入正确的手机号",Toast.LENGTH_SHORT).show();
				}


			}
		});

	}
}

