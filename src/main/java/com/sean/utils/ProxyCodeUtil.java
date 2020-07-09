package com.sean.utils;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author sean
 */
public class ProxyCodeUtil {
    public static void generateClassFile(Class clazz, String proxyName) {
        byte[] classBytes = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        String path = ProxyCodeUtil.class.getResource(".").getPath();
        System.out.println(path);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path + proxyName + ".class");
            out.write(classBytes);
            out.flush();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            if (null != out) {
              try {
                  out.close();
              } catch (Exception e) {
                  e.printStackTrace();
              }
            }
        }
    }
}
