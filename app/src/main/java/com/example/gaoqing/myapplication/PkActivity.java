package com.example.gaoqing.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class PkActivity extends AppCompatActivity {

    ImageView image1;
    ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pk);

        ImageView mImageView01 = (ImageView) findViewById(R.id.girl);
        image1 = (ImageView) findViewById(R.id.eyeleft);
        mImageView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1.setVisibility(View.VISIBLE);
                image2.setVisibility(View.INVISIBLE);
            }
        });

    ImageView mImageView02 = (ImageView) findViewById(R.id.boy);
        image2 = (ImageView) findViewById(R.id.eyeright);
        mImageView02.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            image2.setVisibility(View.VISIBLE);
            image1.setVisibility(View.INVISIBLE);
        }
    });
}
}
