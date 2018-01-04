package com.leizhao.news.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Title: BaseApplication
 * <p>
 * Description: 全局 Application
 * </p>
 * Author 雷钊
 * Date 2018/1/4 09:55
 */
public class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);

        

    }
}
