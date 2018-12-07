package jzm.jeno.com.jzm;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;
import jzm.jeno.com.jzm.bean.MyObjectBox;
import jzm.jeno.com.jzm.utils.ResUtils;

/**
 * author : 宋佳
 * time   : 2018/11/13
 * desc   :
 * version: 1.0.0
 */

public class JzmApplication extends Application {

    private static JzmApplication context;
    public static BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        ResUtils.init();

        boxStore = MyObjectBox.builder().androidContext(this).build();
        if (BuildConfig.DEBUG) {
            new AndroidObjectBrowser(boxStore).start(this);
        }

    }


    public static JzmApplication getContext() {
        return context;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }


    public static BoxStore getBoxStore() {
        return boxStore;
    }


}
