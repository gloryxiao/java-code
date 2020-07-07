package com.sean.base.proxy;

/**
 * @author sean
 */
public class Student implements IPerson {
    @Override
    public void speak() {
        System.out.println("I student speak");
    }

    @Override
    public void action() {
        System.out.println("I student action");
    }
}
