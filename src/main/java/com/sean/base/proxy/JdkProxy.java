package com.sean.base.proxy;

import com.sean.utils.ProxyCodeUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sean
 */
public class JdkProxy {
    public static class StudentHandler implements InvocationHandler {
        private IPerson person;

        public StudentHandler(IPerson person) {
            this.person = person;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before");
            method.invoke(person, args);
            System.out.println("after");

            return null;
        }
    }

    public static void main(String[] args) {
        IPerson person = (IPerson) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), new Class[]{IPerson.class},
                new StudentHandler(new Student()));

        person.speak();
        person.action();
        String proxyClass = "ProxySeanClass";
        ProxyCodeUtil.generateClassFile(person.getClass(), proxyClass);

    }
}
