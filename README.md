# MyUtil Wiki

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)

> 该模块对通用的工具类进行封装, 建议使用submodule的方式进行引用

## 目录

1. BitmapUtils 主要负责Bitmap相关工具方法
2. DeviceUtils 设备属性相关工具类
3. HttpURLConnectionUtils 一个基于HttpURLConnection 简单网络请求工具类
4. LogUtils LOG工具类
5. ManifestUtils manifest工具类
6. MD5Utils MD5相关工具类
7. NetworkUtils 网络相关工具类
8. StringUtils 字符串相关方法
9. ToastUtils Toast相关方法
10. FileUtils 文件相关方法
11. ResourceUtils 资源获取方法
12. ZipUtils 压缩工具方法
13. CacheUtils 使用File存储cache工具类
14. SharePreferenceUtils SharePreference工具类

## 1 BitmapUtils

> 主要负责Bitmap相关工具方法

### 1.1 Bitmap readBitMap(Context context, int resId)

```java
/**
 * RGB_565方式读取资源到Bitmap
 * @param context 全局context
 * @param resId 资源id
 * @return bitmap
 */
```

### 1.2 Bitmap readBitMap(String path)

```java
/**
 * RGB_565方式读取资源到Bitmap
 * @param path 文件图片路径
 * @return bitmap
 */
```

### 1.3 byte[] bitmap2Bytes(Bitmap bitmap)

```java
/**
 * Bitmap 转 byte[]
 * @param bitmap 待转bitmap
 * @return 成功-byte[] 失败-null
 */
```

### 1.4 byte[] compressBitmap(byte[] datas, int byteCount)

```java
/**
 * 压缩图片到指定byte大小 (在保证质量的情况下尽可能压缩 不保证压缩到指定字节)
 * @param datas 图片byte格式
 * @param byteCount 指定压缩到字节数
 * @return 压缩后的byte[] (不保证压缩到指定字节)
 */
```

### 1.5 byte[] compressBitmap(Bitmap bitmap, int byteCount)

```java
/**
 * 压缩图片到指定byte大小 (在保证质量的情况下尽可能压缩 不保证压缩到指定字节)
 * @param bitmap 图片
 * @param byteCount 指定压缩到字节数
 * @return 压缩后的byte[] (不保证压缩到指定字节)
 */
```

## 2 DeviceUtils

> 设备属性相关工具类

### 2.1 int getDeviceDpi(Context context)

```java
/**
 * 获取设备密度
 * @param context 全局context
 * @return 设备dpi
 */
```

### 2.2 int[] getDeviceSize(Context context)

```java
/**
 * 获取设备宽 高 单位像素
 * @param context 全局context
 * @return int[]
 *      [0] 设备宽(像素)
 *      [1] 设备高(像素)
 */
```

### 2.3 int dip2px(Context context, float dpValue)

```java
/**
 * 根据手机的分辨率从从dp转成为px(像素)
 * @param context 全局context
 * @param dpValue dp值
 * @return px像素值
 */
```

### 2.4 int px2dip(Context context, float pxValue)

```java
/**
 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
 * @param context 全局context
 * @param pxValue px像素值
 * @return dp值
 */
```

### 2.5 String getDeviceId(Context context)

```java
/**
 * 获取手机设备id 需要READ_PHONE_STATE权限
 * @param context 全局context
 * @return device id
 */
```

### 2.6 String getSubscriberId(Context context)

```java
/**
 * 获取手机sim卡id 需要READ_PHONE_STATE权限
 * @param context 全局context
 * @return sim id
 */
```

### 2.7 boolean isTabletDevice(Context context)

```java
/**
 * 判断是否平板设备
 * @param context 全局context
 * @return true:平板,false:手机
 */
```

### 2.8 boolean isSdcardExisting()

```java
/**
 * 判断sd卡是否存在
 * @return true:存在；false：不存在
 */
```

### 2.9 long getAvailableInternalStorageSize()

```java
/**
 * 获取手机内部存储剩余空间 单位byte
 * @return
 */
```

### 2.10 long getTotalInternalStorageSize()

```java
/**
 * 获取手机内部总存储空间 单位byte
 * @return
 */
```

### 2.11 long getAvailableExternalStorageSize()

```java
/**
 * 获取SDCARD剩余存储空间 单位byte
 * @return
 */
```

### 2.12 long getTotalExternalStorageSize()

```java
/**
 * 获取SDCARD总的存储空间 单位byte
 * @return
 */
```

## 3 HttpURLConnectionUtils

> 一个基于HttpURLConnection 简单网络请求工具类

### 3.1 doPost(final String url, final Map<String, String> params, final HttpResponseCallBack callback)

```java
/**
 * 异步传输post请求 仅文本参数
 * @param url 请求地址
 * @param params 请求参数
 * @param callback 请求回调
 */
```

### 3.2 doPost(final String url, final Map<String, String> params, final Map<String, String> file, final HttpResponseCallBack callback)

```java
/**
 * 异步传输post请求 文本 文件混合参数
 * @param url 请求地址
 * @param params 文本参数
 * @param file 上传文件参数
 * @param callback 请求回调
 */
```

### 3.3 doGet(final String url, final HttpResponseCallBack callback)

```java
/**
 * 异步传输get请求
 * @param url 请求url
 * @param callback 请求回调
 */
```

## 4 LogUtils

> LOG工具类 默认tag-LOGUTIL

### 4.1 void setLogEnable(boolean enable)

```java
/**
 * 设置是否显示Log
 * @param enable true-显示 false-不显示
 */
```

### 4.2 void v(String msg)  /  void v(String tag, String msg)

```java
/**
 * verbose log
 * @param tag tag
 * @param msg log msg
 */
```

### 4.3 其他的i, d, w, e 都类似以上格式


## 5 ManifestUtils

> manifest工具类

### 5.1 String getMetaData(Context context, String key)

```java
/**
 * 返回Manifest指定meta-data值
 * @param context 全局context
 * @param key meta-data key
 * @return
 *      成功-value
 *      失败-""
 */
```

### 5.2 String getVersionName(Context context)

```java
/**
 * 获取版本名
 * @param context 全局context
 * @return versoin name
 */
```

### 5.3 int getVersionCode(Context context)

```java
/**
 * 获取版本号
 * @param context 全局context
 * @return versoin code
 */
```

## 6 MD5Utils

> MD5相关工具类

### 6.1 String getMd5(String plainText)

```java
/**
 * md5加密
 * @param plainText 待加密字符串
 * @return 加密后32位字符串
 */
```

## 7 NetworkUtils

> 网络相关工具类

### 7.1 Boolean checkNetworkConnect(Context context)

```java
/**
 * 检查网络是否连接
 * @param context 全局context
 * @return true 已连接 false 未连接
 */
```

### 7.2 String getAPNType(Context context)

```java
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
```

## 8 StringUtils

> 字符串相关方法

### 8.1 Boolean isEmpty(String str)

```java
/**
 * 是否为空
 * @param str 字符串
 * @return true 空 false 非空
 */
```

## 9 ToastUtils

> Toast相关方法

### 9.1 void showShort(Context context, int resId) / showLong(Context context, int resId)

```java
/**
 * 显示short/long message
 * @param context 全局context
 * @param resId string string资源id
 */
```

### 9.2 void showShort(Context context, String message) / showLong(Context context, String message)

```java
/**
 * 显示short/long message
 * @param context 全局context
 * @param message 显示msg
 */
```

## 10 FileUtils

> 文件相关方法, 默认存储挂载根目录ROOT_DIR = Environment.getExternalStorageDirectory() + "/"

### 10.1 public static boolean isExist(String path)

```java
/**
 * 文件或者目录是否存在
 * @param path 路径
 * @return true-存在 false-不存在
 */
```

### 10.2 public static String getRootDir()

```java
/**
 * 获取挂载根目录
 * @return ROOT_DIR
 */
```

### 10.3 File makeDir(String path)

```java
/**
 * 判断目录是否存在 不存在则mkdir
 * @param path 路径
 * @return file
 */
```

### 10.4 void deleteFile(String path)

```java
/**
 * 递归删除文件或子文件夹
 * @param path 路径
 */
```

### 10.5 void copyFile(String oldPath, String newPath)

```java
/**
 * 复制单个文件
 * @param oldPath String 原文件路径 如：c:/fqf.txt
 * @param newPath String 复制后路径 如：f:/fqf.txt
 * @return boolean
 */
```

## 11 ResourceUtils

> 资源获取方法

### 11.1 public static String getString(Context context, String stringName)

```java
/**
 * 获取string
 * @param context 上下文
 * @param stringName 字符串名称
 * @return string
 */
```

## 12 ZipUtils

> 压缩工具方法

### 12.1 boolean unzip(String zipFilePath, String unzipPath)

```java
/**
 * 解压
 * @param zipFilePath 压缩文件
 * @param unzipPath 解压路径
 * @return return true if success
 */
```

## 13 CacheUtils

> File存储Cache工具类

### 13.1 存储

```java
CacheUtils.get(context).put(key, val);
```

### 13.2 读取

1. getAsString
1. getAsJSONObject
1. getAsJSONArray
1. getAsBinary
1. getAsObject
1. getAsList
1. getAsBitmap
1. getAsDrawable

## 14 SharePreferenceUtils

> SharePreference工具类

### 14.1 存储

1. putString
1. putInt
1. putBool
1. putFloat
1. putLong

### 14.2 读取

1. getString
1. getInt
1. getBool
1. getFloat
1. getLong

## About Me
简书地址：http://www.jianshu.com/users/21716b19302d/latest_articles

微信公众号

![我的公众号](https://github.com/tsy12321/PayAndroid/blob/master/wxmp_avatar.jpg)

License
-------

    Copyright 2017 SY.Tang

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.