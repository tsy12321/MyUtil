package com.tsy.sdk.myutil;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharePreference工具类
 * Created by tsy on 2016/12/13.
 */

public class SharePreferenceUtils {

    private static String mName = "sharepreference_datas";
    private static SharedPreferences.Editor mEditor;

    /**
     * 设置SharePreferenceName 默认是sharepreference_datas
     * @param name
     */
    public static void setSharePreferenceName(String name) {
        mName = name;
    }

    /**
     * put string val
     * @param context
     * @param key
     * @param val
     */
    public static void putString(Context context, String key, String val) {
        put(context, key, val);
    }

    /**
     * get string val
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context, String key) {
        return (String) get(context, key, "");
    }

    /**
     * get string val
     * @param context
     * @param key
     * @param defaultVal
     * @return
     */
    public static String getString(Context context, String key, String defaultVal) {
        return (String) get(context, key, defaultVal);
    }

    /**
     * put int val
     * @param context
     * @param key
     * @param val
     */
    public static void putInt(Context context, String key, int val) {
        put(context, key, val);
    }

    /**
     * get int val
     * @param context
     * @param key
     * @return
     */
    public static int getInt(Context context, String key) {
        return (int) get(context, key, 0);
    }

    /**
     * get int val
     * @param context
     * @param key
     * @param defaultVal
     * @return
     */
    public static int getInt(Context context, String key, int defaultVal) {
        return (int) get(context, key, defaultVal);
    }

    /**
     * put bool val
     * @param context
     * @param key
     * @param val
     */
    public static void putBool(Context context, String key, Boolean val) {
        put(context, key, val);
    }

    /**
     * get bool val
     * @param context
     * @param key
     * @return
     */
    public static boolean getBool(Context context, String key) {
        return (boolean) get(context, key, false);
    }

    /**
     * get bool val
     * @param context
     * @param key
     * @param defaultVal
     * @return
     */
    public static boolean getBool(Context context, String key, Boolean defaultVal) {
        return (boolean) get(context, key, defaultVal);
    }

    /**
     * put float val
     * @param context
     * @param key
     * @param val
     */
    public static void putFloat(Context context, String key, Float val) {
        put(context, key, val);
    }

    /**
     * get float val
     * @param context
     * @param key
     * @return
     */
    public static float getFloat(Context context, String key) {
        return (float) get(context, key, 0.0f);
    }

    /**
     * get float val
     * @param context
     * @param key
     * @param defaultVal
     * @return
     */
    public static float getFloat(Context context, String key, Float defaultVal) {
        return (float) get(context, key, defaultVal);
    }

    /**
     * put long int val
     * @param context
     * @param key
     * @param val
     */
    public static void putLong(Context context, String key, Long val) {
        put(context, key, val);
    }

    /**
     * get long val
     * @param context
     * @param key
     * @return
     */
    public static long getLong(Context context, String key) {
        return (long) get(context, key, 0L);
    }

    /**
     * get long val
     * @param context
     * @param key
     * @param defaultVal
     * @return
     */
    public static long getLong(Context context, String key, Long defaultVal) {
        return (long) get(context, key, defaultVal);
    }

    /**
     * 移除某个key值已经对应的值
     * @param key
     */
    public static void remove(Context context, String key) {
        if (mEditor == null) {
            setEditor(context);
        }
        mEditor.remove(key);
        mEditor.commit();
    }

    /**
     * 清除所有的数据
     */
    public static void clear(Context context) {
        if (mEditor == null) {
            setEditor(context);
        }
        mEditor.clear();
        mEditor.commit();
    }

    /**
     * 查询某个key是否存在
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mName, Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

    private static void setEditor(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mName, Context.MODE_PRIVATE);
        mEditor = sharedPreferences.edit();
    }

    private static Object get(Context context, String key, Object defaultObject) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mName, Context.MODE_PRIVATE);

        if (defaultObject instanceof String) {
            return sharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sharedPreferences.getLong(key, (Long) defaultObject);
        } else {
            return sharedPreferences.getString(key, null);
        }
    }

    private static void put(Context context, String key, Object object) {
        if (mEditor == null) {
            setEditor(context);
        }

        if (object instanceof String) {
            mEditor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            mEditor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            mEditor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            mEditor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            mEditor.putLong(key, (Long) object);
        } else {
            mEditor.putString(key, object.toString());
        }
        mEditor.commit();
    }
}
