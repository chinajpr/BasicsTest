package com.example.jpr.basicstest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jpr.basicstest.R;

/**
 * 类描述:
 * 创建日期:2017/11/21 on 15:51
 * 作者:JiaoPeiRong
 */

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void arrayList(View view){
        Intent i = new Intent(this , ArrayAdapterTest.class);
        startActivity(i);
    }

    public void pop(View view){
        Intent i = new Intent(this , PopWindowActivity.class);
        startActivity(i);
    }
}
