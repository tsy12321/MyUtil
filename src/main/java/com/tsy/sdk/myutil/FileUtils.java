package com.tsy.sdk.myutil;

import android.os.Environment;

import java.io.File;

/**
 * File工具类
 * Created by tsy on 16/9/5.
 */
public class FileUtils {

    /**
     * 文件或者目录是否存在
     * @param path 路径
     * @return true-存在 false-不存在
     */
    public static boolean isExist(String path) {
        File file = new File(Environment.getExternalStorageDirectory() + path);
        return file.exists();
    }

    /**
     * 获取挂载根目录
     * @return ROOT_DIR
     */
    public static String getRootDir() {
        return Environment.getExternalStorageDirectory() + "";
    }

    /**
     * 判断目录是否存在 不存在则mkdir
     * @param path 路径
     * @return file
     */
    public static File makeDir(String path) {
        File file = new File(Environment.getExternalStorageDirectory() + path);
        if(!file.exists()) {
            file.mkdirs();
        }

        return file;
    }

    /**
     * 递归删除文件或子文件夹
     * @param path 路径
     */
    public static void deleteFile(String path) {
        File file = new File(path);
        if(!file.exists()) {
            return;
        }

        if(file.isFile()) {
            file.delete();
            return;
        }

        if(file.isDirectory()) {
            for(File f : file.listFiles()) {
                deleteFile(f.getAbsolutePath());
            }
            file.delete();
        } else{
            file.delete();
        }
    }
}
