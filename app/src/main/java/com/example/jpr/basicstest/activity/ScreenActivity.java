package com.example.jpr.basicstest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jpr.basicstest.R;
import com.example.jpr.basicstest.utils.SupportMultipleScreensUtil;

/**
 * 类描述:
 * 创建日期:2017/12/8 on 10:16
 * 作者:JiaoPeiRong
 */

public class ScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        View rootView = findViewById(R.id.ll);
        SupportMultipleScreensUtil.init(getApplication());
        SupportMultipleScreensUtil.scale(rootView);
    }
}
