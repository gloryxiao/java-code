package com.sean.base.detailintoproxy;

import com.sean.base.proxy.IPerson;
import com.sean.base.proxy.JdkProxy;
import com.sean.base.proxy.Student;
import com.sean.utils.ProxyCodeUtil;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Proxy;

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

    @Test
    public void testWriteClass() throws Exception {
        IPerson proxyPerson = (IPerson) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), new Class[]{IPerson.class},
                new JdkProxy.StudentHandler(new Student()));
        String proxyClass = "ProxySeanClass";
        ProxyCodeUtil.generateClassFile(proxyPerson.getClass(), proxyClass);
    }
}