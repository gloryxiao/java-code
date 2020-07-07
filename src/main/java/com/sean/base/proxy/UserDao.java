package com.sean.base.proxy;

public class UserDao {
    /**
    *   没有借口声明，使用cglib创建动态代理
    *
    */
    public void update() {
        System.out.println("User Dao, update");
    }

    public int select() {
        System.out.println("User Dao, select 1");
        return 1;
    }
}
