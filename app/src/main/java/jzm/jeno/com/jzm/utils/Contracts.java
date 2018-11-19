package jzm.jeno.com.jzm.utils;

import io.reactivex.Observable;
import jzm.jeno.com.jzm.bean.JzmNewBean;
import jzm.jeno.com.jzm.bean.SearchInfo;
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


    public static final String KEY_PARAMS = "key_params";


    public static final String BASE_URL = "http://www.juzimi.com";


    public interface Apis {

        // https://www.juzimi.com/new?page=1
        @GET("/new")
        @Html
        Observable<JzmNewBean> getHotPageNew(@Query("page") int page);


        @GET("/new")
        @Html
        Observable<SearchInfo> getHotPageNew2(@Query("page") int page);


    }


}
