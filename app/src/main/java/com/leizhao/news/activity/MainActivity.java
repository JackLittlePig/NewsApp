package com.leizhao.news.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.leizhao.news.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        float screenDensity = ScreenUtils.getScreenDensity();

        LogUtils.d("screenDensity = " + screenDensity);





    }
}
