package jzm.jeno.com.jzm;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import jzm.jeno.com.jzm.utils.ResUtils;

/**
 * author : 宋佳
 * time   : 2018/11/13
 * desc   :
 * version: 1.0.0
 */

public class JzmApplication extends Application {

    private static JzmApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        ResUtils.init();
    }


    public static JzmApplication getContext() {
        return context;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }





}
