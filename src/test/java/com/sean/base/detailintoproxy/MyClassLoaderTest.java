package com.sean.base.detailintoproxy;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoaderTest {
    @Test
    public void testLoadClass() throws Exception{
        InputStream inputStream = new FileInputStream("/home/sean/Workspace/Sean/java-code/target/classes/com/sean/base/detailintoproxy/Programmer.class");
        byte[] bytes = new byte[1024];
        int count = inputStream.read(bytes);

        MyClassLoader myClassLoader = new MyClassLoader();
        Class clazz = myClassLoader.defineMyClass(bytes, 0, count);
        System.out.println(clazz.getCanonicalName());

        Object object = clazz.newInstance();
        try {
            clazz.getMethod("code", null).invoke(object, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}