package com.sean.base;

public class ThreadlocalDemo {
    public static void main(String[] args){
        Thread t1 = new Thread(
                () -> {
                    SessionTest test = new SessionTest();
                    test.setName("sean-1");
                    test.echoName();
                    test.echo();
                }
        );

        Thread t2 = new Thread(
                () -> {
                    SessionTest test = new SessionTest();
                    test.setName("sean-2");
                    test.echoName();
                    test.echo();
                }
        );

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception ignore) {

        }

    }

}
