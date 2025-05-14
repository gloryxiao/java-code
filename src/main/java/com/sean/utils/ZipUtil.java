package com.sean.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtil {
    /**
     * zip文件解压
     * @param inputFile  待解压文件夹/文件
     * @param destDirPath  解压路径
     */
    public static void unZip(String inputFile, String destDirPath) throws Exception {
        // 创建待解压文件对象
        File srcFile = new File(inputFile);
        // 判断待解压文件是否存在
        if (!srcFile.exists()) {
            throw new Exception(srcFile.getPath() + "所指文件不存在");
        }

        // 创建ZipFile对象
        ZipFile zipFile = new ZipFile(srcFile);
        // 获取ZipFile中的所有文件和文件夹
        Enumeration<?> entries = zipFile.entries();
        // 遍历所有文件和文件夹
        while (entries.hasMoreElements()) {
            // 获取当前文件或文件夹
            ZipEntry entry = (ZipEntry) entries.nextElement();
            // 判断当前文件或文件夹是否为文件夹
            if (entry.isDirectory()) {
                // 创建文件夹
                String dirPath = destDirPath + "/" + entry.getName();
                new File(dirPath).mkdirs();
            } else {
                // 创建文件
                File targetFile = new File(destDirPath + "/" + entry.getName());
                // 判断文件所在的文件夹是否存在
                if (!targetFile.getParentFile().exists()) {
                    // 创建文件夹
                    targetFile.getParentFile().mkdirs();
                }

                // 创建文件
                targetFile.createNewFile();
                // 获取文件输入流
                InputStream is = zipFile.getInputStream(entry);
                // 获取文件输出流
                FileOutputStream fos = new FileOutputStream(targetFile);
                // 定义缓冲区
                int len;
                byte[] buf = new byte[1024];
                // 读取文件内容并写入缓冲区
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }

                // 关闭文件输出流
                fos.close();
                // 关闭文件输入流
                is.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            unZip("/home/sean/tmp/keycenter.zip", "/home/sean/tmp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
