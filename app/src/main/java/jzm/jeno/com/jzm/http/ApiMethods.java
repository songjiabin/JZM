package jzm.jeno.com.jzm.http;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import jzm.jeno.com.jzm.utils.Contracts;

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


    /**
     * 得到句子迷new 列表信息
     */
    public static void getJzmTodayInfo(int page, Observer observer) {
        ApiSubscribe(ApiStrategy.getApiService().getHotPageTodayHot(page), observer);
    }


    /**
     * d得到 轮播
     */
    public static void getJzmNewImgInfo(Observer observer) {
        ApiSubscribe(ApiStrategy.getApiService(Contracts.BASE_IMG_URL).getHotPageNewImgBean(), observer);
    }


    /**
     * 推荐
     */

    public static void getJzmRecommendInfo(int page, Observer observer) {
        ApiSubscribe(ApiStrategy.getApiService().getHotPageRecommend(page), observer);
    }


    /**
     * 最受欢迎
     */

    public static void getJzmTotallikeInfo(int page, Observer observer) {
        ApiSubscribe(ApiStrategy.getApiService().getHotPageTotallike(page), observer);
    }


    /**
     * 经典对白
     */

    public static void getJzmDialogueInfo(int page, Observer observer) {
        ApiSubscribe(ApiStrategy.getApiService().getDialogueInfo(page), observer);
    }


}
