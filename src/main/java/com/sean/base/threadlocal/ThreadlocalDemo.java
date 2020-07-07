package com.sean.base.threadlocal;


import java.util.concurrent.TimeUnit;

public class ThreadlocalDemo {
    public static void main(String[] args){
        Thread t1 = new Thread(
                () -> {
                    SessionTest test = new SessionTest();
                    test.setName("sean-1");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    test.echoName();
                    test.echo();
                }
        );

        Thread t2 = new Thread(
                () -> {
                    SessionTest test = new SessionTest();
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
