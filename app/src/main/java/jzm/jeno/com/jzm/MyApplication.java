package jzm.jeno.com.jzm;

import android.app.Application;

import jzm.jeno.com.jzm.utils.ResUtils;

/**
 * author : 宋佳
 * time   : 2018/11/13
 * desc   :
 * version: 1.0.0
 */

public class MyApplication extends Application {

    private static MyApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        ResUtils.init();
    }


    public static MyApplication getContext() {
        return context;
    }

}
