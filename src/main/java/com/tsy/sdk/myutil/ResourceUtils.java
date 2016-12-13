package com.tsy.sdk.myutil;

import android.content.Context;
import android.content.res.Resources;

/**
 * 资源换取方法
 * Created by HYM on 16/9/9.
 */
public class ResourceUtils {

    /**
     * 获取string
     * @param context 上下文
     * @param stringName 字符串名称
     * @return string
     */
    public static String getString(Context context, String stringName) {
        String ret = "";
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(context.getPackageName() + ":string/" + stringName, null, null);
        if (identifier > 0) {
            ret = resources.getString(identifier);
        }
        return ret;
    }
}
