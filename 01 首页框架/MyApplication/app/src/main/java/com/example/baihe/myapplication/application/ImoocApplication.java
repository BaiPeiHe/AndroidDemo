package com.example.baihe.myapplication.application;

import android.app.Application;

/**
 * Created by baihe on 2017/7/6.
 */

public class ImoocApplication extends Application {

    private static ImoocApplication mApplication = null;


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static ImoocApplication getInstance() {
        return mApplication;
    }
}
