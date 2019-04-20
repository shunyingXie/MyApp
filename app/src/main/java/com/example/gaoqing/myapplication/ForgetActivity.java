package com.example.gaoqing.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForgetActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        text=(TextView) findViewById(R.id.textView);
        Button btSignup=(Button)findViewById(R.id.botton);
        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setVisibility(View.VISIBLE);
                mHandler.postDelayed(r, 5000);//延时5000毫秒
            }
        });

    }

    Handler mHandler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            text.setVisibility(View.INVISIBLE);
        }
    };




}

