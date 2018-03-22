package com.xiumei.housekeeper.util;

import android.util.Log;

import com.xiumei.housekeeper.config.AppConfig;

/**
 * @des 日志打印工具类
 * Created by zjj on 2018/3/21 11:26.
 */

public class LogUtils {

    public static void e(String tag, String msg) {
        if (AppConfig.isDebug)
            Log.e(tag, msg + "");
    }

}
