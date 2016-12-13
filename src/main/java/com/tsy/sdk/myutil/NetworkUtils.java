package com.tsy.sdk.myutil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * 网络相关工具类
 * Created by tsy on 16/7/21.
 */
public class NetworkUtils {

    /**
     * 检查网络是否连接
     * @param context 全局context
     * @return true 已连接 false 未连接
     */
    public static Boolean checkNetworkConnect(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }

        return false;
    }

    /**
     * 获取当前的网络状态
     * @param context 全局context
     * @return
     * 没有网络-NO
     * WIFI网络-WIFI
     * 4G网络-4G
     * 3G网络-3G
     * 2G网络-2G
     * 未知-Unknown
     */
    public static String getAPNType(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo == null) {      //无网络
            return "NO";
        }

        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_WIFI) {       //wifi
            return "WIFI";
        } else if (nType == ConnectivityManager.TYPE_MOBILE) {
            int nSubType = networkInfo.getSubtype();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (nSubType == TelephonyManager.NETWORK_TYPE_LTE
                    && !telephonyManager.isNetworkRoaming()) {
                return "4G";
            } else if (nSubType == TelephonyManager.NETWORK_TYPE_UMTS
                    || nSubType == TelephonyManager.NETWORK_TYPE_EVDO_0
                    || nSubType == TelephonyManager.NETWORK_TYPE_EVDO_A
                    || nSubType == TelephonyManager.NETWORK_TYPE_HSDPA
                    || nSubType == TelephonyManager.NETWORK_TYPE_HSUPA
                    || nSubType == TelephonyManager.NETWORK_TYPE_HSPA
                    || nSubType == TelephonyManager.NETWORK_TYPE_EVDO_B
                    || nSubType == TelephonyManager.NETWORK_TYPE_EHRPD
                    || nSubType == TelephonyManager.NETWORK_TYPE_HSPAP
                    && !telephonyManager.isNetworkRoaming()) {
                return "3G";
            } else if (nSubType == TelephonyManager.NETWORK_TYPE_GPRS
                    || nSubType == TelephonyManager.NETWORK_TYPE_EDGE
                    || nSubType == TelephonyManager.NETWORK_TYPE_CDMA
                    || nSubType == TelephonyManager.NETWORK_TYPE_1xRTT
                    || nSubType == TelephonyManager.NETWORK_TYPE_IDEN
                    && !telephonyManager.isNetworkRoaming()) {
                return "2G";
            } else {
                return "Unknown";
            }
        }

        return "Unknown";
    }
}
