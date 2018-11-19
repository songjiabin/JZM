package jzm.jeno.com.jzm.http;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author : 宋佳
 * time   : 2018/11/02
 * desc   :
 * version: 1.0.0
 */

public class ApiMethods {


    public static void ApiSubscribe(Observable observable, Observer observer) {
        //上流
        observable.
                subscribeOn(Schedulers.io())//上流的线程
                .unsubscribeOn(Schedulers.io())//取消上流的线程
                .observeOn(AndroidSchedulers.mainThread())//下流的线程
                .subscribe(observer);
    }

    /**
     * 得到句子迷new 列表信息
     */
    public static void getJzmNewInfo(int page, Observer observer) {
        ApiSubscribe(ApiStrategy.getApiService().getHotPageNew(page), observer);
    }





    public static void getJzmNewInfo2(int page, Observer observer) {
        ApiSubscribe(ApiStrategy.getApiService().getHotPageNew2(page), observer);
    }



}
