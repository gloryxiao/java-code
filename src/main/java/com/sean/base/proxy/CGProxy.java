package com.sean.base.proxy;

import net.sf.cglib.proxy.Enhancer;

public class CGProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        UserDao dao = new UserDao();
        enhancer.setSuperclass(dao.getClass());
        enhancer.setCallback(new DaoInterceptor());

        UserDao d = (UserDao) enhancer.create();

        d.select();
        d.update();
    }
}
