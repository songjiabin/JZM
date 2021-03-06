package jzm.jeno.com.jzm.utils;

import android.content.Context;

import jzm.jeno.com.jzm.JzmApplication;

/**
 * author : 宋佳
 * time   : 2018/11/15
 * desc   :
 * version: 1.0.0
 */

public class ResUtils {

    private static Context context;

    public static void init() {
        context = JzmApplication.getContext();
    }


    public static String[] getStringArray(int array) {
        return context.getResources().getStringArray(array);
    }


    public static String getString(int resId) {
        return context.getResources().getString(resId);
    }

}
