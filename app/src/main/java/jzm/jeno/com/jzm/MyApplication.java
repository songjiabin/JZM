package jzm.jeno.com.jzm;

import android.app.Application;

/**
 * author : 宋佳
 * time   : 2018/11/13
 * desc   :
 * version: 1.0.0
 */

public class MyApplication extends Application {

    private MyApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }


    public MyApplication getContext() {
        return context;
    }

}
