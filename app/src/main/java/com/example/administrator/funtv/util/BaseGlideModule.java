package com.example.administrator.funtv.util;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by Administrator on 2017/4/5 0005.
 */

public class BaseGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();//获取系统分配给应用的总内存大小
        int memoryCacheSize = maxMemory /8;//设置图片内存缓存占用八分之一
        builder.setBitmapPool(new LruBitmapPool(memoryCacheSize));//设置 BitmapPool 缓存内存大小
        builder.setMemoryCache(new LruResourceCache(memoryCacheSize));//设置内存缓存大小


    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
