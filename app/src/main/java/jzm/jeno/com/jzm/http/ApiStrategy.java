package jzm.jeno.com.jzm.http;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jzm.jeno.com.jzm.MyApplication;
import jzm.jeno.com.jzm.utils.Contracts;
import me.ghui.fruit.Fruit;
import me.ghui.fruit.converter.retrofit.FruitConverterFactory;
import me.ghui.retrofit.converter.GlobalConverterFactory;
import me.ghui.retrofit.converter.annotations.Html;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * author : 宋佳
 * time   : 2018/11/02
 * desc   :
 * version: 1.0.0
 */

public class ApiStrategy {

    //读超时长，单位：毫秒
    public static final int READ_TIME_OUT = 7676;
    //连接时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 7676;

    private static final long TIMEOUT_LENGTH = 15;
    /**
     * 设缓存有效期为两天
     */
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;


    public static Contracts.Apis apiService;
    private static OkHttpClient mOkHttpClient;
    private Fruit mFruit;

    public static Contracts.Apis getApiService() {
        if (apiService == null) {
            synchronized (Api.class) {
                if (apiService == null) {
                    new ApiStrategy();
                }
            }
        }
        return apiService;
    }

    private ApiStrategy() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(Contracts.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
                //适配RxJava2.0,RxJava1.x则为RxJavaCallAdapterFactory.create()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GlobalConverterFactory.create().add(FruitConverterFactory.create(getFruit()), Html.class))
                .build();
        apiService = retrofit.create(Contracts.Apis.class);


    }


    private Fruit getFruit() {
        if (mFruit == null) {
            mFruit = new Fruit();
        }
        return mFruit;
    }


    public static OkHttpClient getOkHttpClient() {


        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .cache(getCache())

                    .connectTimeout(TIMEOUT_LENGTH, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    // 修改useragent防止请求失效
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request()
                                    .newBuilder()
                                    .removeHeader("User-Agent")
                                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko")
                                    .build();
                            return chain.proceed(request);
                        }
                    })
                    // cookie本地持久化

                    .build();
        }
        return mOkHttpClient;
    }

    public static Cache getCache() {
        File httpCacheDirectory = new File(MyApplication.getContext().getCacheDir(), "okhttp_cache");
        return new Cache(httpCacheDirectory, 10 * 1024 * 1024);         // 缓存空间10M
    }


}
