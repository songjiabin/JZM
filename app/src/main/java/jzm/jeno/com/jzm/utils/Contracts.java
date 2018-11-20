package jzm.jeno.com.jzm.utils;

import io.reactivex.Observable;
import jzm.jeno.com.jzm.bean.JzmDialogueBean;
import jzm.jeno.com.jzm.bean.JzmNewBean;
import jzm.jeno.com.jzm.bean.JzmNewImgBean;
import me.ghui.retrofit.converter.annotations.Html;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author : 宋佳
 * time   : 2018/11/14
 * desc   :
 * version: 1.0.0
 */

public class Contracts {

    public static long MB = 1024 * 1024;
    public static String CachePath = "linesImageCache";
    public static String SAVE_CARD_PATH = "/sdcard/Lines/";
    public static String SAVE_DIALOGUE_PATH = "/sdcard/LinesDialogue/";

    public static final String KEY_PARAMS = "key_params";


    public static final String BASE_URL = "http://www.juzimi.com";


    public static final String BASE_IMG_URL = "http://www.wufazhuce.com";


    public interface Apis {

        // https://www.juzimi.com/new?page=1 今日最新
        @GET("/new")
        @Html
        Observable<JzmNewBean> getHotPageNew(@Query("page") int page);


        //http://www.wufazhuce.com/  图片
        @GET("/")
        @Html
        Observable<JzmNewImgBean> getHotPageNewImgBean();


        //https://www.juzimi.com/todayhot 今日热门
        @GET("/todayhot")
        @Html
        Observable<JzmNewBean> getHotPageTodayHot(@Query("page") int page);


        // https://www.juzimi.com/recommend  今日推荐
        @GET("/recommend")
        @Html
        Observable<JzmNewBean> getHotPageRecommend(@Query("page") int page);


        // 最受欢迎 https://www.juzimi.com/totallike
        @GET("/totallike")
        @Html
        Observable<JzmNewBean> getHotPageTotallike(@Query("page") int page);


        //截图 经典对白    https://www.juzimi.com/meitumeiju/jingdianduibai
        @GET("/meitumeiju/jingdianduibai")
        Observable<JzmDialogueBean> getDialogueInfo(@Query("page") int page);


    }


}
