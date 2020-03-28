package com.sean.base.concurrency;


import java.util.concurrent.TimeUnit;

public class SynchronizedDeath {
    private final static Object lock1 = new Object();
    private final static Object lock2 = new Object();

    private static class RunTest implements Runnable {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + ": get lock1");

                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + ": get lock 2");
                    try {
                        lock1.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + ": lock 2 end");
            }

            System.out.println(Thread.currentThread().getName() + ": lock 1 end");
        }
    }

    private static class RunTest2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + ": lock 1 get");

                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + ": lock 2 get");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunTest(), "sean-t1");
        Thread t2 = new Thread(new RunTest2(), "sean-t2");

        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(10);
            t1.interrupt();
            t2.interrupt();
//            t1.join();
//            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}