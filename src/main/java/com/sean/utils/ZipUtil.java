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
        File srcFile = new File(inputFile);
        if (!srcFile.exists()) {
            throw new Exception(srcFile.getPath() + "所指文件不存在");
        }

        ZipFile zipFile = new ZipFile(srcFile);
        Enumeration<?> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            if (entry.isDirectory()) {
                String dirPath = destDirPath + "/" + entry.getName();
                new File(dirPath).mkdirs();
            } else {
                File targetFile = new File(destDirPath + "/" + entry.getName());
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }

                targetFile.createNewFile();
                InputStream is = zipFile.getInputStream(entry);
                FileOutputStream fos = new FileOutputStream(targetFile);
                int len;
                byte[] buf = new byte[1024];
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }

                fos.close();
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
