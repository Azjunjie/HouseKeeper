package com.xiumei.housekeeper.util;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Priority;
import com.xiumei.housekeeper.R;
import com.xiumei.housekeeper.config.GlideApp;

/**
 * @des glide图片加载工具类
 * Created by zjj on 2018/3/21 15:15.
 */

public class GlideUtils {

    /**
     * 加载图片资源
     *
     * @param context 上下文
     * @param res     图片资源
     * @param iv      需要设置图片资源的view
     */
    public static void load(Context context, @Nullable Object res, @NonNull ImageView iv) {
        GlideApp.with(context)
                .load(res)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(iv);
    }

    public static void load(Activity activity, @Nullable Object res, @NonNull ImageView iv) {
        GlideApp.with(activity)
                .load(res)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(iv);
    }

    public static void load(Fragment fragment, @Nullable Object res, @NonNull ImageView iv) {
        GlideApp.with(fragment)
                .load(res)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(iv);
    }

    /**
     * 优先加载图片资源
     *
     * @param context 上下文
     * @param res     图片资源
     * @param iv      需要设置图片资源的view
     */
    public static void loadPriority(Context context, @Nullable Object res, @NonNull ImageView iv) {
        GlideApp.with(context)
                .load(res)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .into(iv);
    }

    public static void loadPriority(Activity activity, @Nullable Object res, @NonNull ImageView iv) {
        GlideApp.with(activity)
                .load(res)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .into(iv);
    }

    public static void loadPriority(Fragment fragment, @Nullable Object res, @NonNull ImageView iv) {
        GlideApp.with(fragment)
                .load(res)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .into(iv);
    }

    /**
     * 取消图片加载
     *
     * @param context 上下文
     * @param iv      需要取消释放资源的view
     */
    public static void clear(Context context, ImageView iv) {
        GlideApp.with(context)
                .clear(iv);
    }

    public static void clear(Activity activity, ImageView iv) {
        GlideApp.with(activity)
                .clear(iv);
    }

    public static void clear(Fragment fragment, ImageView iv) {
        GlideApp.with(fragment)
                .clear(iv);
    }

}
