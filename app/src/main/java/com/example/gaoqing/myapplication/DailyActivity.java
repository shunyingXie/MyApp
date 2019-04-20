package com.example.gaoqing.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import utils.WaveDrawable;


public class DailyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        WaveDrawable waveDrawable = new WaveDrawable(this, R.drawable.mountain);//本地图片
        waveDrawable.setWaveLength(500);//设置波长
        waveDrawable.setWaveSpeed(20);//设定波的移动速度
        waveDrawable.setWaveAmplitude(20);//设置波幅
        waveDrawable.setIndeterminate(true);//运行不确定模式,一直运行
        waveDrawable.setLevel(10);//设置水位
//waveDrawable.setIndeterminateAnimator();//自定义动画,设置不确定模式下的波浪加载动画

        //layout背景设置动图
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.layout);
        linearLayout.setBackground(waveDrawable);



    }
}
