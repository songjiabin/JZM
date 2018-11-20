package jzm.jeno.com.jzm.ImageUtil;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

import jzm.jeno.com.jzm.JzmApplication;
import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/20
 * desc   :
 * version: 1.0.0
 */
@GlideModule
public class MyAppGlideModule extends AppGlideModule {
    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
    }


    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

        long availableDiskSize = DiskUtils.getSDAvailableSize();
        long diskCacheSizeBytes = availableDiskSize > 500 * Contracts.MB ? 250 * Contracts.MB : availableDiskSize / 2;

        //设置磁盘缓存
        builder.setDiskCache(new InternalCacheDiskCacheFactory(
                JzmApplication.getContext(),
                Contracts.CachePath,
                diskCacheSizeBytes));

        //添加默认请求配置
        builder.setDefaultRequestOptions(
                new RequestOptions().format(DecodeFormat.PREFER_RGB_565).disallowHardwareConfig()
        );
    }
}
