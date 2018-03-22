package com.xiumei.housekeeper.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @des Toast工具类
 * Created by zjj on 2018/3/21 10:35.
 */

public class ToastUtils {
    private static Toast sToast;

    /**
     * @param context 上下文
     * @param msg     提示的文本内容
     */
    public static void showToast(Context context, String msg) {
        if (sToast == null) {
            synchronized (ToastUtils.class) {
                if (sToast == null) {
                    sToast = Toast.makeText(context, msg + "", Toast.LENGTH_SHORT);
                }
            }
        } else {
            sToast.setText(msg + "");
            sToast.setDuration(Toast.LENGTH_SHORT);
        }
        sToast.show();
    }

}
